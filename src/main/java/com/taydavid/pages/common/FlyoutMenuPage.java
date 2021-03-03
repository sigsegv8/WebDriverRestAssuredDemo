package com.taydavid.pages.common;

public class FlyoutMenuPage {
	private FlyoutMenuPageController action;

	/**
	 * Flyout menu action controller
	 * 
	 * @return
	 */
	public FlyoutMenuPageController action() {
		return action;
	}

	private FlyoutMenuPage() {
	}

	private FlyoutMenuPage(FlyoutMenuPageController action) {
		this.action = action;
	}

	public static FlyoutMenuPage getFlyoutMenuPage() {
		return new FlyoutMenuPage(new FlyoutMenuPageController());
	}
}
