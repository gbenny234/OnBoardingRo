package com.Onboarding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPatient extends SignUpPatientPageBot {

	WebDriver driver;
	String emailAddress;

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		SignUpPatientCommonFunctions.dataLoad();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// capabilities.setCapability("marionette", true);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(SignUpPatientCommonFunctions.urL());
		driver.manage().window().maximize();
		emailAddress = SignUpPatientCommonFunctions.generateEmail(8);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// Test to validate profile creationg
	@Test(priority = 8)
	public void createProfileWithValidData() throws InterruptedException {

		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(welcomeHeader()).getText()
				.contains("Hi " + SignUpPatientCommonFunctions.profileFirstName()));

	}

	// Test to validate missing email domain.
	@Test(priority = 1)
	public void invalidEmailDomain() throws InterruptedException {

		driver.findElement(emailAddressField()).sendKeys(emailAddress);
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Assert.assertTrue(driver.findElement(emailDomainMissing()).isDisplayed());

	}

	// Test to validate empty email field.
	@Test(priority = 2)
	public void emptyEmailField() throws InterruptedException {
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(emailFieldRequired()).isDisplayed());

	}

//Test to validate First name empty field.
	@Test(priority = 4)
	public void emptyFirstnameField() throws InterruptedException {

		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		Thread.sleep(2000);
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(firstNameFieldRequired()).isDisplayed());

	}

	// Test to validate empty lastname field.
	@Test(priority = 5)
	public void emptyLastnameField() throws InterruptedException {

		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(firstNameFieldRequired()).isDisplayed());

	}

	// Test to validate password with no uppercase or numbers
	@Test(priority = 6)
	public void invalidPasswordNoUppercaseLetter() throws InterruptedException {
		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Assert.assertTrue(driver.findElement(invalidPasswordNoUppercase()).isDisplayed());

	}

	// Test to validate if the lenght of password is less than 8.
	@Test(priority = 7)
	public void invalidPasswordLessLenght() throws InterruptedException {
		emailAddress = SignUpPatientCommonFunctions.generateEmail(5);
		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress);
		driver.findElement(privacyAccept()).click();
		driver.findElement(submit()).click();
		Assert.assertTrue(driver.findElement(invalidPasswordLenghtLess()).isDisplayed());

	}

	// Test to validate if privacy checkbox is left unchecked.
	@Test(priority = 3)
	public void privacyUnChecked() throws InterruptedException {
		driver.findElement(emailAddressField()).sendKeys(emailAddress + "@Ro.com");
		driver.findElement(firstName()).sendKeys(SignUpPatientCommonFunctions.profileFirstName());
		driver.findElement(lastName()).sendKeys(SignUpPatientCommonFunctions.profileLastName());
		driver.findElement(password()).sendKeys(emailAddress.toUpperCase() + 1);
		driver.findElement(submit()).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(privacyNotChecked()).size() > 0);

	}

}
