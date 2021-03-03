package com.taydavid.pages.register;

public class RegisterFormPage {
	private RegisterFormPageController action;

	/**
	 * Register action controller
	 * 
	 * @return
	 */
	public RegisterFormPageController action() {
		return action;
	}

	private RegisterFormPage() {
	}

	private RegisterFormPage(RegisterFormPageController action) {
		this.action = action;
	}

	public static RegisterFormPage getRegisterFormPage() {
		return new RegisterFormPage(new RegisterFormPageController());
	}
}
