package com.taydavid.pages.myaccount;

public class MyAccountPage {
	private MyAccountPageController action;

	/**
	 * My Account Page action controller
	 * 
	 * @return
	 */
	public MyAccountPageController action() {
		return action;
	}

	private MyAccountPage() {
	}

	private MyAccountPage(MyAccountPageController action) {
		this.action = action;
	}

	public static MyAccountPage getMyAccountPage() {
		return new MyAccountPage(new MyAccountPageController());
	}
}
