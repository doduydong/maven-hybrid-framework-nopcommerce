package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserBackInStockSubscriptionsPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserBackInStockSubscriptionsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
