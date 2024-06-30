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
import page.object.user.UserLoginPageObject;
import page.object.user.UserRegisterPageObject;
import page.object.user.myaccount.UserCustomerInfoPageObject;
import utilities.ExtentReportsListener;

public class User_02_Login_01_Mandatory_Data extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private String firstName, lastName, emailAddress, password;
	private String invalidEmail, notFoundEmail, wrongPass;

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
		notFoundEmail = "sdet.dong@gmail.com";
		wrongPass = "JavaSe4@";

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");
		userHomePage = userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
		userHomePage.clickHeaderLinkByLinkText("Log out");
	}

	@Test
	public void Login_01_Empty_Data(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_01_Empty_Data");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_01 - Step 01: Click 'Log in' header link");
		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_01 - Step 02: Clear 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_01 - Step 03: Clear 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_01 - Step 04: Click 'Log in' button");
		userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_01 - Step 05: Verify 'Email' error message");
		Assert.assertEquals(userLoginPage.getEmailTextboxErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_02_Invalid_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_02 - Step 01: Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_02 - Step 02: Enter '" + invalidEmail + "' to 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox(invalidEmail);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_02 - Step 03: Enter '" + password + "' to 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_02 - Step 04: Click 'Log in' button");
		userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_02 - Step 05: Verify 'Email' error message");
		Assert.assertEquals(userLoginPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Login_03_Not_Found_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_03_Not_Found_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_03 - Step 01: Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_03 - Step 02: Enter '" + notFoundEmail + "' to 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox(notFoundEmail);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_03 - Step 03: Enter '" + password + "' to 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_03 - Step 04: Click 'Log in' button");
		userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_03 - Step 05: Verify 'Email' error message");
		Assert.assertEquals(userLoginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Without_Password(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_04_Without_Password");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_04 - Step 01: Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_04 - Step 02: Enter '" + emailAddress + "' to 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_04 - Step 03: Clear 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox("");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_04 - Step 04: Click 'Log in' button");
		userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_04 - Step 05: Verify 'Email' error message");
		Assert.assertEquals(userLoginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Wrong_Password(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_05_Wrong_Password");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_05 - Step 01: Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_05 - Step 02: Enter '" + emailAddress + "' to 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_05 - Step 03: Enter '" + wrongPass + "' to 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox(wrongPass);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_05 - Step 04: Click 'Log in' button");
		userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_05 - Step 05: Verify 'Email' error message");
		Assert.assertEquals(userLoginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Data(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] Login_05_Wrong_Password");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 01: Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 02: Enter '" + emailAddress + "' to 'Email' textbox");
		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 03: Enter '" + password + "' to 'Password' textbox");
		userLoginPage.sendKeysToPasswordTextbox(password);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 04: Click 'Log in' button");
		userHomePage = userLoginPage.clickLoginButton();

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 05: Click 'My account' header link");
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 06: Verify 'My account - Customer info' page title");
		Assert.assertEquals(userCustomerInfoPage.getCustomerPageTitle(), "My account - Customer info");

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 07: Verify 'First name' textbox value is '" + firstName + "'");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 08: Verify 'Last name' textbox value is '" + lastName + "'");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 09: Verify 'Email' textbox value is '" + emailAddress + "'");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "Login_06 - Step 10: Click 'Log out' header link");
		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
