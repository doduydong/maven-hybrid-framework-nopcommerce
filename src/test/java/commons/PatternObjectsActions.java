package commons;

import org.openqa.selenium.WebDriver;

public class PatternObjectsActions extends BasePage {
	private WebDriver driver;

	public PatternObjectsActions(WebDriver driver) {
		this.driver = driver;
	}

	public PatternObjectsActions clickHeaderLinkByLinkText(String linkText) {
		waitForElementClickable(driver, PatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, PatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Register":
			return PagesGeneratorManager.getUserRegisterPage(driver);
		case "My account":
			return PagesGeneratorManager.getUserCustomerInfoPage(driver);
		case "Log out":
			return PagesGeneratorManager.getUserHomePage(driver);
		case "Log in":
			return PagesGeneratorManager.getUserLoginPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' link is invalid");
		}
	}

	public String getBarNotificationSuccessMessage() {
		waitForElementVisible(driver, PatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		String message = getElementText(driver, PatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		waitForElementClickable(driver, PatternObjectsUIs.BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		clickElement(driver, PatternObjectsUIs.BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		waitForElementInvisible(driver, PatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		return message;
	}

}
