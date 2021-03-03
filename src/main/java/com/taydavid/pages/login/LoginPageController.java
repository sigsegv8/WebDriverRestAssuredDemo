package com.taydavid.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class LoginPageController extends BasePageController {

	private static final String LOGIN_PAGE_URL = "https://www.credify.tech/portal/login";

	@FindBy(name = "username")
	private WebElement txtUserName;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(css = "button[data-auto='login']")
	private WebElement btnLogin;

	public LoginPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Open login page
	 * 
	 * @return
	 */
	public LoginPageController goToLoginPage() {
		DriverFactory.INSTANCE.openUrl(LOGIN_PAGE_URL);
		return this;
	}

	/**
	 * Perform login
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginPageController login(final String username, final String password) {
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		return this;
	}

}
