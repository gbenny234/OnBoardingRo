package com.Onboarding;

import org.openqa.selenium.By;

public abstract class SignUpPatientPageBot {

	/*
	 * This function returns locator for the email address field
	 */
	public static By emailAddressField() {
		String emailAddy = "//input[@id='temporaryEmail' and @autocomplete='false']";

		return By.xpath(emailAddy);

	}

	/*
	 * This function returns locator for the Firstname field
	 */

	public static By firstName() {
		String firstName = "//*[@id='firstName']";

		return By.xpath(firstName);

	}

	/*
	 * This function returns locator for the lastname field
	 */
	public static By lastName() {
		String lastName = "//*[@id='lastName']";

		return By.xpath(lastName);

	}

	/*
	 * This function returns locator for the error message indicating invalid email
	 * address
	 */
	public static By emailDomainMissing() {
		String lastName = "//div[text()='Email format invalid']";

		return By.xpath(lastName);

	}

	/*
	 * This function returns locator for the password field
	 */
	public static By password() {
		String password = "//*[@id='password']";

		return By.xpath(password);

	}

	/*
	 * This function returns locator for the privacy acceptance checkbox
	 */
	public static By privacyAccept() {
		String privacyAccept = "//button[text()='Start my visit']//preceding::div[1]";

		return By.xpath(privacyAccept);

	}

	/*
	 * This function returns locator for the submit button
	 */
	public static By submit() {
		String privacyAccept = "//button[text()='Start my visit']";

		return By.xpath(privacyAccept);

	}

	/*
	 * This function returns locator for the welcome header in the welcomepage
	 */
	public static By welcomeHeader() {
		String welcomeHeader = "//h2[@class='heading start-heading']";

		return By.xpath(welcomeHeader);

	}

	/*
	 * This function returns locator for the error message shown as a result of
	 * empty email address.
	 */
	public static By emailFieldRequired() {
		String emailFieldRequired = "//*[@id='firstName']//preceding::div[text()='Field required']";

		return By.xpath(emailFieldRequired);

	}

	/*
	 * This function returns locator for the error message shown as a result of
	 * first name field being empty.
	 */
	public static By firstNameFieldRequired() {
		String firstNameFieldRequired = "//*[@id='password']//preceding::div[text()='Field required']";

		return By.xpath(firstNameFieldRequired);

	}

	/*
	 * This function returns locator for the error message shown as a result of
	 * invalid password.
	 */
	public static By invalidPasswordNoUppercase() {
		String invalidPassword = "//*[@id='password']//following::div[text()='Password is not strong enough']";

		return By.xpath(invalidPassword);

	}

	/*
	 * This function returns locator for the error message shown as a result of
	 * invalid password.
	 */
	public static By invalidPasswordLenghtLess() {
		String invalidPasswordLenghtLess = "//*[@id='password']//following::div[text()='Password must be 8 characters or more']";

		return By.xpath(invalidPasswordLenghtLess);

	}

	/*
	 * This function returns locator for the error message shown as a result of
	 * privacy box not checked.
	 */
	public static By privacyNotChecked() {
		String privacyNotChecked = "//input[@name='agreedToTos' and @value='false']";

		return By.xpath(privacyNotChecked);

	}

}
