package page.object.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PagesGeneratorManager;
import page.ui.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public String getFirstNameTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
	}

	public String getLastNameTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
	}

	public String getEmailTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
	}

	public String getPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_TEXTBOX_ERROR_MESSAGE);
	}

	public String getConfirmPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public UserHomePageObject clickContinueButton() {
		waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PagesGeneratorManager.getUserHomePage(driver);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public void clickRegisterHeaderLink() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_HEADER_LINK);
		clickElement(driver, UserRegisterPageUI.REGISTER_HEADER_LINK);
	}

}
