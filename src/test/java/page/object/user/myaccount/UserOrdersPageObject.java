package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserOrdersPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
