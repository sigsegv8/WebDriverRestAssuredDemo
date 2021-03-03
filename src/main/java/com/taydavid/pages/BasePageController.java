package com.taydavid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.taydavid.factory.DriverFactory;

public class BasePageController {

	public static final String TEST_PASSWORD = "abcDef12!3";

	@FindBy(css = "div[data-fetching]")
	protected WebElement progressSpinner;

	public BasePageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Common overlay spinner when pages are loading
	 * 
	 */
	protected final void waitUntilProgressSpinnerCompleted() {
		DriverFactory.INSTANCE.getWebDriverWait(30).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return progressSpinner.getAttribute("data-fetching").equals("false");
			}
		});
	}
}
