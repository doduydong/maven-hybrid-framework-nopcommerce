package page.object.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PagesGeneratorManager;
import page.ui.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCustomerPageTitle() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
		return getElementText(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public UserHomePageObject clickLogoutHeaderLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.LOGOUT_HEADER_LINK);
		clickElement(driver, UserCustomerInfoPageUI.LOGOUT_HEADER_LINK);
		return PagesGeneratorManager.getUserHomePage(driver);
	}

}
