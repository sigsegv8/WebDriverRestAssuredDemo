package com.taydavid.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class FlyoutMenuPageController extends BasePageController {

	@FindBy(className = "header-nav")
	private WebElement btnMenu;

	@FindBy(className = "header-nav-menu")
	private WebElement menuMain;

	@FindBy(css = "a[href='/funnel/logout']")
	private WebElement txtLogout;

	@FindBy(css = "h1[data-auto='logoutMessage']")
	private WebElement txtLogOutMessage;

	public FlyoutMenuPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Logout from flyout menu
	 * 
	 * @return
	 */
	public FlyoutMenuPageController logOut() {
		super.waitUntilProgressSpinnerCompleted();
		btnMenu.click();
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtLogout));
		txtLogout.click();
		DriverFactory.INSTANCE.getWebDriverWait().until(ExpectedConditions.visibilityOf(txtLogOutMessage));
		return this;
	}

}
