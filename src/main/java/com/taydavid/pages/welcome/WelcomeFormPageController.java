package com.taydavid.pages.welcome;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class WelcomeFormPageController extends BasePageController {

	@FindBy(name = "desiredAmount")
	private WebElement txtLoanAmount;

	@FindBy(css = "select[data-auto='dropLoanPurpose']")
	private WebElement ddlLoanPurpose;

	@FindBy(css = "button[data-auto='CheckYourRate']")
	private WebElement btnCheckYourRate;

	public WelcomeFormPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Input loan amount for inquiry
	 * 
	 * @param loanAmount
	 * @param dropDownOption
	 * @return
	 */
	public WelcomeFormPageController inputLoanInquiry(final String loanAmount, final String dropDownOption) {
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtLoanAmount));
		txtLoanAmount.sendKeys(loanAmount);
		final Select loadPurposeSelect = new Select(ddlLoanPurpose);
		loadPurposeSelect.selectByValue(dropDownOption);
		btnCheckYourRate.click();
		return this;
	}
}
