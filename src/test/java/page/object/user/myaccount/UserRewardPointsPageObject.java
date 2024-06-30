package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserRewardPointsPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserRewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
