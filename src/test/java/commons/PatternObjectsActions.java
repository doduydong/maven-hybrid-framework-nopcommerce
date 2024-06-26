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
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' link is invalid");
		}
	}

}
