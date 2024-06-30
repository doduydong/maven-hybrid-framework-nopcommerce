package page.object.user;

import org.openqa.selenium.WebDriver;

import commons.PagesGeneratorManager;
import commons.PatternObjectsActions;
import page.ui.user.UserLoginPageUI;

public class UserLoginPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePageObject clickLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PagesGeneratorManager.getUserHomePage(driver);
	}

	public String getEmailTextboxErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getLoginErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

	public UserHomePageObject loginToSystem(String emailAddress, String password) {
		sendKeysToEmailTextbox(emailAddress);
		sendKeysToPasswordTextbox(password);
		return clickLoginButton();
	}

}
