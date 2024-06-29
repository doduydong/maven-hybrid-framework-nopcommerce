package commons;

import org.openqa.selenium.WebDriver;

import page.object.user.UserCustomerInfoPageObject;
import page.object.user.UserHomePageObject;
import page.object.user.UserLoginPageObject;
import page.object.user.UserRegisterPageObject;

public class PagesGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static PatternObjectsActions getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

}
