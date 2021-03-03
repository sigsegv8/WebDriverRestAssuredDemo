package com.taydavid.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.taydavid.factory.DriverFactory;
import com.taydavid.pages.BasePageController;
import com.taydavid.pages.common.FlyoutMenuPage;
import com.taydavid.pages.income.IncomeFormPage;
import com.taydavid.pages.login.LoginPage;
import com.taydavid.pages.myaccount.MyAccountPage;
import com.taydavid.pages.personal.PersonalInfoFormPage;
import com.taydavid.pages.register.RegisterFormPage;
import com.taydavid.pages.welcome.WelcomeFormPage;
import com.taydavid.tests.UITest;

/**
 * Verify via the UI that as a borrower - you are seeing loan offers, upon
 * filling the required form fields with valid inputs.
 * 
 * @author tayda
 *
 */
public class BorrowerInquiryTest extends UITest {

	private static final String STARTING_URL = "https://www.credify.tech/phone/nonDMFunnel";

	private WelcomeFormPage mWelcomeFormPage;
	private PersonalInfoFormPage mPersonalInfoFormPage;
	private IncomeFormPage mIncomeFormPage;
	private RegisterFormPage mRegisterFormPage;
	private MyAccountPage mMyAccountPage;
	private LoginPage mLoginPage;
	private FlyoutMenuPage mFlyOutMenuPage;

	@BeforeMethod
	public void beforeMethod() {
		DriverFactory.INSTANCE.openUrl(STARTING_URL);
		mWelcomeFormPage = WelcomeFormPage.getWelcomeFormPage();
		mPersonalInfoFormPage = PersonalInfoFormPage.getPersonalInfoFormPage();
		mIncomeFormPage = IncomeFormPage.getIncomeFormPage();
		mRegisterFormPage = RegisterFormPage.getRegisterFormPage();
		mMyAccountPage = MyAccountPage.getMyAccountPage();
		mFlyOutMenuPage = FlyoutMenuPage.getFlyoutMenuPage();
		mLoginPage = LoginPage.getLoginPage();
	}

	@Test(dataProvider = "loanInquiryFormData")
	public void testNewBorrowerInquiry(final String loanAmount, final String loanType, final String address,
			final String income, final String additionalIncome) throws InterruptedException {
		mWelcomeFormPage.action().inputLoanInquiry(loanAmount, loanType);
		mPersonalInfoFormPage.action().inputPersonalInfo(address);
		mIncomeFormPage.action().inputIncome(income, additionalIncome);
		mRegisterFormPage.action().registerAccount();
		final String username = mRegisterFormPage.action().getRegisteredUserName();
		mMyAccountPage.action().checkLoanDetails();

		final String loanAmountQualified = mMyAccountPage.action().getLoanAmount();
		final String monthlyPayment = mMyAccountPage.action().getMonthlyPayment();
		final String term = mMyAccountPage.action().getLoanTerm();
		final String interestRate = mMyAccountPage.action().getLoanInterestRate();
		final String apr = mMyAccountPage.action().getAPR();

		mFlyOutMenuPage.action().logOut();
		mLoginPage.action().goToLoginPage();
		mLoginPage.action().login(username, BasePageController.TEST_PASSWORD);
		mMyAccountPage.action().checkLoanDetails();

		Assert.assertEquals(mMyAccountPage.action().getLoanAmount(), loanAmountQualified);
		Assert.assertEquals(mMyAccountPage.action().getMonthlyPayment(), monthlyPayment);
		Assert.assertEquals(mMyAccountPage.action().getLoanTerm(), term);
		Assert.assertEquals(mMyAccountPage.action().getLoanInterestRate(), interestRate);
		Assert.assertEquals(mMyAccountPage.action().getAPR(), apr);
	}

	@DataProvider(name = "loanInquiryFormData")
	public Object[][] formData() {
		Object[][] data = new Object[1][5];

		// Loan Inquiry Amount, Loan Type, Address, Income, Additional Income
		data[0][0] = "2000";
		data[0][1] = "CREDIT_CARD";
		data[0][2] = "10100 Reflections Boulevard North";
		data[0][3] = "121000";
		data[0][4] = "5100";
		return data;
	}
}
