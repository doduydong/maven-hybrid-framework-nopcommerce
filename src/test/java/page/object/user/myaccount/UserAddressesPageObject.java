package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserAddressesPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
