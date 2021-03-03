package com.taydavid.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.taydavid.factory.DriverFactory;

public class UITest {

	@BeforeMethod
	@Parameters({ "browser" })
	public void startUpBrowser(@Optional("chrome") String browser) {
		DriverFactory.INSTANCE.initWebDriver(browser.replace("\"", ""));
	}

	@AfterMethod
	public void closeBrowser() {
		DriverFactory.INSTANCE.quitWebDriver();
	}
}
