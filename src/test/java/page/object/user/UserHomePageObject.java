package page.object.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PagesGeneratorManager;
import page.ui.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickRegisterHeaderLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_HEADER_LINK);
		clickElement(driver, UserHomePageUI.REGISTER_HEADER_LINK);
		return PagesGeneratorManager.getUserRegisterPage(driver);
	}

	public UserCustomerInfoPageObject clickMyAccountHeaderLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
		clickElement(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
		return PagesGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
