package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserChangePasswordPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
