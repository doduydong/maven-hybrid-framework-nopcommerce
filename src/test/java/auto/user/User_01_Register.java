package auto.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		userRegisterPage = userHomePage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox("");

		userRegisterPage.sendKeysToLastNameTextbox("");

		userRegisterPage.sendKeysToEmailTextbox("");

		userRegisterPage.sendKeysToPasswordTextbox("");

		userRegisterPage.sendKeysToConfirmPasswordTextbox("");

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getFirstNameTextboxErrorMessage(), "First name is required.");

		Assert.assertEquals(userRegisterPage.getLastNameTextboxErrorMessage(), "Last name is required.");

		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Email is required.");

		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		userRegisterPage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(invalidEmail);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Invalid_Password() {
		userRegisterPage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(invalidPass);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(invalidPass);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getPasswordTextboxErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters and not greater than 64 characters");
	}

	@Test
	public void Register_04_Wrong_Confirm_Password() {
		userRegisterPage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(wrongPass);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Valid_Data() {
		userRegisterPage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickContinueButton();

		userCustomerInfoPage = userHomePage.clickMyAccountHeaderLink();

		Assert.assertEquals(userCustomerInfoPage.getCustomerPageTitle(), "My account - Customer info");

		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);

		userHomePage = userCustomerInfoPage.clickLogoutHeaderLink();
	}

	@Test
	public void Register_06_Existing_Email() {
		userRegisterPage = userHomePage.clickRegisterHeaderLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
