package com.taydavid.pages.register;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class RegisterFormPageController extends BasePageController {

	private Faker mFaker = new Faker();

	private String mRegisteredUserName;

	@FindBy(name = "username")
	private WebElement txtEmailAddress;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(name = "agreements")
	private WebElement cbAgreement;

	@FindBy(css = "button[data-auto='submitPersonalInfo']")
	private WebElement btnSubmit;

	public RegisterFormPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Register a new account
	 * 
	 * @return
	 */
	public RegisterFormPageController registerAccount() {
		mRegisteredUserName = "davidtay" + mFaker.number().randomNumber(6, false) + "@upgrade-challenge.com";
		txtEmailAddress.sendKeys(mRegisteredUserName);
		txtPassword.sendKeys(BasePageController.TEST_PASSWORD);
		txtPassword.sendKeys(Keys.TAB);
		Actions actions = new Actions(DriverFactory.INSTANCE.getWebDriver());
		actions.moveToElement(cbAgreement).click().build().perform();
		btnSubmit.click();

		return this;
	}

	public String getRegisteredUserName() {
		return mRegisteredUserName;
	}
}
