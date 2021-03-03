package com.taydavid.pages.welcome;

/**
 * Home Page representation
 * 
 * @author tayda
 *
 */
public class WelcomeFormPage {
	private WelcomeFormPageController action;

	/**
	 * Home Page Action controller
	 * 
	 * @return
	 */
	public WelcomeFormPageController action() {
		return action;
	}

	private WelcomeFormPage() {
	}

	private WelcomeFormPage(WelcomeFormPageController action) {
		this.action = action;
	}

	public static WelcomeFormPage getWelcomeFormPage() {
		return new WelcomeFormPage(new WelcomeFormPageController());
	}
}
