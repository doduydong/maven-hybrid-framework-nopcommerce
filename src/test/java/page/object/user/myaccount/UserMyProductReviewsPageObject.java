package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserMyProductReviewsPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
