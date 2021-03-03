package com.taydavid.pages.personal;

import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class PersonalInfoFormPageController extends BasePageController {

	private Faker mFaker = new Faker();

	@FindBy(css = "input[data-auto='borrowerFirstName']")
	private WebElement txtFirstName;

	@FindBy(css = "input[data-auto='borrowerLastName']")
	private WebElement txtLastName;

	@FindBy(css = "input[data-auto='borrowerStreet']")
	private WebElement txtHomeAddress;

	@FindBy(css = "input[data-auto='borrowerCity']")
	private WebElement txtCity;

	@FindBy(css = "input[data-auto='borrowerState']")
	private WebElement txtState;

	@FindBy(css = "input[data-auto='borrowerZipCode']")
	private WebElement txtZipCode;

	@FindBy(css = "input[data-auto='borrowerDateOfBirth']")
	private WebElement txtDateOfBirth;

	@FindBy(css = "button[data-auto='continuePersonalInfo']")
	private WebElement btnContinue;

	public PersonalInfoFormPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Input personal information for loan inquiry
	 * 
	 * @param address
	 * @return
	 */
	public PersonalInfoFormPageController inputPersonalInfo(final String address) {
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtFirstName));
		txtFirstName.sendKeys(mFaker.name().firstName());
		txtLastName.sendKeys(mFaker.name().lastName());
		txtHomeAddress.sendKeys(address);
		final List<WebElement> addressSuggestions = DriverFactory.INSTANCE.getWebDriverWait()
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[role='option']"), 0));
		addressSuggestions.get(0).click();
		txtDateOfBirth.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(mFaker.date().birthday(18, 65)));
		btnContinue.click();
		return this;
	}
}
