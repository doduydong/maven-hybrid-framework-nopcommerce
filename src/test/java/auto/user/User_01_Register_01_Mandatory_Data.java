package auto.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PagesGeneratorManager;
import page.object.user.UserHomePageObject;
import page.object.user.UserRegisterPageObject;
import page.object.user.myaccount.UserCustomerInfoPageObject;
import utilities.ExtentReportsListener;

public class User_01_Register_01_Mandatory_Data extends BaseTest {
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
	public void Register_01_Empty_Data(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_01_Empty_Data");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 01: Click 'Register' header link");
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 02: Clear 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 03: Clear 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 04: Clear 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 05: Clear 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 06: Clear 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 08: Verify 'First name' error message");
		Assert.assertEquals(userRegisterPage.getFirstNameTextboxErrorMessage(), "First name is required.");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 09: Verify 'Last name' error message");
		Assert.assertEquals(userRegisterPage.getLastNameTextboxErrorMessage(), "Last name is required.");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 10: Verify 'Email' error message");
		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Email is required.");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_01 - Step 11: Verify 'Confirm password' error message");
		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_02_Invalid_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 04: Enter '" + invalidEmail + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(invalidEmail);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_02 - Step 08: Verify 'Email' error message");
		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Invalid_Password(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_03_Invalid_Password");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 05: Enter '" + invalidPass + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(invalidPass);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 06: Enter '" + invalidPass + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(invalidPass);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_03 - Step 08: Verify 'Password' error message");
		Assert.assertEquals(userRegisterPage.getPasswordTextboxErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters and not greater than 64 characters");
	}

	@Test
	public void Register_04_Wrong_Confirm_Password(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_04_Wrong_Confirm_Password");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 06: Enter '" + wrongPass + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(wrongPass);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_04 - Step 08: Verify 'Confirm password' error message");
		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Valid_Data(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_05_Valid_Data");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 01: Click 'Register' header link");
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 08: Verify registration completed message");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 09: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 10: Click 'My account' header link");
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 11: Verify 'My account - Customer info' page title");
		Assert.assertEquals(userCustomerInfoPage.getCustomerPageTitle(), "My account - Customer info");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 12: Verify 'First name' textbox value is '" + firstName + "'");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 13: Verify 'Last name' textbox value is '" + lastName + "'");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 14: Verify 'Email' textbox value is '" + emailAddress + "'");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_05 - Step 15: Click 'Log out' header link");
		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");
	}

	@Test
	public void Register_06_Existing_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "Register_06_Existing_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 01: Click 'Register' header link");
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 02: Enter '" + firstName + "' to 'First name' textbox");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 03: Enter '" + lastName + "' to 'Last name' textbox");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 04: Enter '" + emailAddress + "' to 'Email' textbox");
		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 05: Enter '" + password + "' to 'Password' textbox");
		userRegisterPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 06: Enter '" + password + "' to 'Confirm password' textbox");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Register_06 - Step 08: Verify existing email error message");
		Assert.assertEquals(userRegisterPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
