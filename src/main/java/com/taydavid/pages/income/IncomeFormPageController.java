package com.taydavid.pages.income;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class IncomeFormPageController extends BasePageController {

	@FindBy(css = "input[data-auto='borrowerIncome']")
	private WebElement txtBorrowerIncome;

	@FindBy(css = "input[data-auto='borrowerAdditionalIncome']")
	private WebElement txtBorrowerAdditionalIncome;

	@FindBy(css = "button[data-auto='continuePersonalInfo']")
	private WebElement btnContinue;

	public IncomeFormPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Input income information into loan inquiry form
	 * 
	 * @param income
	 * @param additionalIncome
	 * @return
	 */
	public IncomeFormPageController inputIncome(final String income, final String additionalIncome) {
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtBorrowerIncome));
		txtBorrowerIncome.sendKeys(income);
		txtBorrowerAdditionalIncome.sendKeys(additionalIncome);
		txtBorrowerAdditionalIncome.sendKeys(Keys.TAB);
		btnContinue.click();
		return this;
	}
}
