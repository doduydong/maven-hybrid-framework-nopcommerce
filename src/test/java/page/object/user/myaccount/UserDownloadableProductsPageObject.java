package page.object.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.PatternObjectsActions;

public class UserDownloadableProductsPageObject extends PatternObjectsActions {
	private WebDriver driver;

	public UserDownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
