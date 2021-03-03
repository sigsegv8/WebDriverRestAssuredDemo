package com.taydavid.pages.income;

public class IncomeFormPage {
	private IncomeFormPageController action;

	/**
	 * Income form action controller
	 * 
	 * @return
	 */
	public IncomeFormPageController action() {
		return action;
	}

	private IncomeFormPage() {
	}

	private IncomeFormPage(IncomeFormPageController action) {
		this.action = action;
	}

	public static IncomeFormPage getIncomeFormPage() {
		return new IncomeFormPage(new IncomeFormPageController());
	}
}
