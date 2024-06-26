package page.object.user;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserHomePageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
