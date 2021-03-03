package com.taydavid.pages.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;

public class MyAccountPageController extends BasePageController {

	private String mLoanAmount;
	private String mMonthlyPayment;
	private String mLoanTerm;
	private String mLoanInterestRate;
	private String mPaidToDebt;
	private String mApr;

	@FindBy(css = "span[data-auto='userLoanAmount']")
	private WebElement txtLoanAmount;

	@FindBy(css = "span[data-auto='defaultMonthlyPayment']")
	private WebElement txtMonthlyPayment;

	@FindBy(css = "div[data-auto='defaultLoanTerm']")
	private WebElement txtLoanTerm;

	@FindBy(css = "div[data-auto='defaultLoanInterestRate']")
	private WebElement txtLoanInterestRate;

	@FindBy(css = "div[data-auto='defaultMoreInfoAPR']")
	private WebElement txtAPR;

	@FindBy(css = "div[data-auto='directPayMinimumAmount']")
	private WebElement txtPaidToDebt;

	public MyAccountPageController() {
		PageFactory.initElements(DriverFactory.INSTANCE.getWebDriver(), this);
	}

	/**
	 * Get loan details from the main my account page
	 * 
	 * @return
	 */
	public MyAccountPageController checkLoanDetails() {
		super.waitUntilProgressSpinnerCompleted();
		DriverFactory.INSTANCE.getWebDriverWait().until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return txtLoanAmount.getText().length() != 0;
			}
		});

		mLoanAmount = txtLoanAmount.getText();
		mMonthlyPayment = txtMonthlyPayment.getText();
		mLoanTerm = txtLoanTerm.getText().split(" ")[0];
		mLoanInterestRate = txtLoanInterestRate.getText().split(" ")[0];
		mApr = txtAPR.getText().split(" ")[0];
		mPaidToDebt = txtPaidToDebt.getText().split(" ")[0];
		return this;
	}

	public String getLoanAmount() {
		return mLoanAmount;
	}

	public String getMonthlyPayment() {
		return mMonthlyPayment;
	}

	public String getLoanTerm() {
		return mLoanTerm;
	}

	public String getLoanInterestRate() {
		return mLoanInterestRate;
	}

	public String getAPR() {
		return mApr;
	}

	public String getPaidToDebt() {
		return mPaidToDebt;
	}
}
