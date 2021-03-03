package com.taydavid.pages.personal;

public class PersonalInfoFormPage {
	private PersonalInfoFormPageController action;

	/**
	 * Personal Info From action controller
	 * 
	 * @return
	 */
	public PersonalInfoFormPageController action() {
		return action;
	}

	private PersonalInfoFormPage() {
	}

	private PersonalInfoFormPage(PersonalInfoFormPageController action) {
		this.action = action;
	}

	public static PersonalInfoFormPage getPersonalInfoFormPage() {
		return new PersonalInfoFormPage(new PersonalInfoFormPageController());
	}
}
