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

public class User_03_My_Account_01_Customer_Info extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserLoginPageObject userLoginPage;
	private String firstName, lastName, emailAddress, password;
	private String newFirstName, newLastName, newEmailAddress;

	@BeforeClass
	@Parameters({ "browser", "site", "server" })
	public void beforeClass(String browserName, String siteName, String serverName) {
		driver = initDriver(browserName, siteName, serverName);
		userHomePage = PagesGeneratorManager.getUserHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dong.sdet" + getRandomNumber() + "@gmail.com";
		password = "SeJava4@";

		newFirstName = "Giorno";
		newLastName = "Giovanna";
		newEmailAddress = "jojo" + getRandomNumber() + "@gmail.com";

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");
		userHomePage = userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
	}

	@Test
	public void My_Account_01_Verify_Customer_Info(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] My_Account_01_Verify_Customer_Info");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_01 - Step 01: Click 'My account' header link");
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_01 - Step 02: Verify 'My account - Customer info' page title");
		Assert.assertEquals(userCustomerInfoPage.getCustomerPageTitle(), "My account - Customer info");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_01 - Step 03: Verify 'First name' textbox value is '" + firstName + "'");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_01 - Step 04: Verify 'Last name' textbox value is '" + lastName + "'");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_01 - Step 05: Verify 'Email' textbox value is '" + emailAddress + "'");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);
	}

	@Test
	public void My_Account_02_Update_Customer_Info(Method method) {
		ExtentReportsListener.startTest(method.getName(), "[START] My_Account_02_Update_Customer_Info");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 01: Change 'First name' textbox value from '" + firstName + "' to '" + newFirstName + "'");
		userCustomerInfoPage.sendKeysToFirstNameTextbox(newFirstName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 02: Change 'Last name' textbox value from '" + lastName + "' to '" + newLastName + "'");
		userCustomerInfoPage.sendKeysToLastNameTextbox(newLastName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 03: Change 'Email' textbox value from '" + emailAddress + "' to '" + newEmailAddress + "'");
		userCustomerInfoPage.sendKeysToEmailTextbox(newEmailAddress);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 04 - Click 'Save' button");
		userCustomerInfoPage.clickSaveButton();

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 05 - Verify Bar Notification Success Message");
		Assert.assertEquals(userCustomerInfoPage.getBarNotificationSuccessMessage(), "The customer info has been updated successfully.");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 06 - Verify 'First name' textbox value is '" + newFirstName + "'");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), newFirstName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 07 - Verify 'Last name' textbox value is '" + newLastName + "'");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), newLastName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_02 - Step 08 - Verify 'Email name' textbox value is '" + newEmailAddress + "'");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), newEmailAddress);
	}

	@Test
	public void My_Account_03_Login_With_Old_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "My_Account_03_Login_With_Old_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_03 - Step 01 - Click 'Log out' header link");
		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_03 - Step 02 - Click 'Log in' header link");
		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_03 - Step 03 - Login with Email: '" + emailAddress + "' and Password: '" + password + "'");
		userLoginPage.loginToSystem(emailAddress, password);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_03 - Step 05 - Verify log in error message");
		Assert.assertEquals(userLoginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void My_Account_04_Login_With_New_Email(Method method) {
		ExtentReportsListener.startTest(method.getName(), "My_Account_04_Login_With_New_Email");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 01 - Click 'Log in' header link");
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 02 - Login with Email: '" + newEmailAddress + "' and Password: '" + password + "'");
		userHomePage = userLoginPage.loginToSystem(newEmailAddress, password);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 03 - Click 'My account' header link");
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 04 - Verify 'First name' textbox value is '" + newFirstName + "'");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), newFirstName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 05 - Verify 'Last name' textbox value is '" + newLastName + "'");
		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), newLastName);

		ExtentReportsListener.getTest().log(Status.INFO, "My_Account_04 - Step 06 - Verify 'Email' textbox value is '" + newEmailAddress + "'");
		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), newEmailAddress);
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
