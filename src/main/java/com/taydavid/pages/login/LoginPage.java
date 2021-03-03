package com.taydavid.pages.login;

public class LoginPage {
	private LoginPageController action;

	/**
	 * Login action controller
	 * 
	 * @return
	 */
	public LoginPageController action() {
		return action;
	}

	private LoginPage() {
	}

	private LoginPage(LoginPageController action) {
		this.action = action;
	}

	public static LoginPage getLoginPage() {
		return new LoginPage(new LoginPageController());
	}
}
