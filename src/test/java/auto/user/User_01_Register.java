package auto.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PagesGeneratorManager;
import page.object.user.UserCustomerInfoPageObject;
import page.object.user.UserHomePageObject;
import page.object.user.UserRegisterPageObject;

public class User_01_Register extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private String firstName, lastName, emailAddress, password;
	private String invalidEmail, invalidPass, wrongPass;

	@BeforeClass
	@Parameters({ "browser", "site", "server" })
	public void beforeClass(String browserName, String siteName, String serverName) {
		driver = initDriver(browserName, siteName, serverName);
		userHomePage = PagesGeneratorManager.getUserHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dong.sdet" + getRandomNumber() + "@gmail.com";
		password = "SeJava4@";

		invalidEmail = "dong.sdet@gmail@com";
		invalidPass = "Se4@";
		wrongPass = "JavaSe4@";
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("[START] Register_01_Empty_Data");

		log.info("Register_01 - Step 01: Click 'Register' header link");
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		log.info("Register_01 - Step 02: Clear 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox("");

		log.info("Register_01 - Step 03: Clear 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox("");

		log.info("Register_01 - Step 04: Clear 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox("");

		log.info("Register_01 - Step 05: Clear 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox("");

		log.info("Register_01 - Step 06: Clear 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox("");

		log.info("Register_01 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_01 - Step 08: Verify 'First name' error message");
		verify(userRegisterPage.getFirstNameTextboxErrorMessage(), "First name is required.");

		log.info("Register_01 - Step 09: Verify 'Last name' error message");
		verify(userRegisterPage.getLastNameTextboxErrorMessage(), "Last name is required.");

		log.info("Register_01 - Step 10: Verify 'Email' error message");
		verify(userRegisterPage.getEmailTextboxErrorMessage(), "Email is required.");

		log.info("Register_01 - Step 11: Verify 'Confirm password' error message");
		verify(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("[START] Register_02_Invalid_Email");

		log.info("Register_02 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		log.info("Register_02 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Register_02 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Register_02 - Step 04: Enter '" + invalidEmail + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(invalidEmail);

		log.info("Register_02 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		log.info("Register_02 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		log.info("Register_02 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_02 - Step 08: Verify 'Email' error message");
		verify(userRegisterPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Invalid_Password() {
		log.info("[START] Register_03_Invalid_Password");

		log.info("Register_03 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		log.info("Register_03 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Register_03 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Register_03 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Register_03 - Step 05: Enter '" + invalidPass + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(invalidPass);

		log.info("Register_03 - Step 06: Enter '" + invalidPass + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(invalidPass);

		log.info("Register_03 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_03 - Step 08: Verify 'Password' error message");
		verify(userRegisterPage.getPasswordTextboxErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters and not greater than 64 characters");
	}

	@Test
	public void Register_04_Wrong_Confirm_Password() {
		log.info("[START] Register_04_Wrong_Confirm_Password");

		log.info("Register_04 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		log.info("Register_04 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Register_04 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Register_04 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Register_04 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		log.info("Register_04 - Step 06: Enter '" + wrongPass + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(wrongPass);

		log.info("Register_04 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_04 - Step 08: Verify 'Confirm password' error message");
		verify(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Valid_Data() {
		log.info("[START] Register_05_Valid_Data");

		log.info("Register_05 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		log.info("Register_05 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Register_05 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Register_05 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Register_05 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		log.info("Register_05 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		log.info("Register_05 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_05 - Step 08: Verify registration completed message");
		verify(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register_05 - Step 09: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();

		log.info("Register_05 - Step 10: Click 'My account' header link");
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		log.info("Register_05 - Step 11: Verify 'My account - Customer info' page title");
		verify(userCustomerInfoPage.getCustomerPageTitle(), "My account - Customer info");

		log.info("Register_05 - Step 12: Verify 'First name' textbox value is '" + firstName + "'");
		verify(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		log.info("Register_05 - Step 13: Verify 'Last name' textbox value is '" + lastName + "'");
		verify(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		log.info("Register_05 - Step 14: Verify 'Email' textbox value is '" + emailAddress + "'");
		verify(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);

		log.info("Register_05 - Step 15: Click 'Log out' header link");
		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");
	}

	@Test
	public void Register_06_Existing_Email() {
		log.info("[START] Register_06_Existing_Email");

		log.info("Register_06 - Step 01: Click 'Register' header link");
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		log.info("Register_06 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Register_06 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Register_06 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Register_06 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		log.info("Register_06 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		log.info("Register_06 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register_06 - Step 08: Verify existing email error message");
		verify(userRegisterPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
