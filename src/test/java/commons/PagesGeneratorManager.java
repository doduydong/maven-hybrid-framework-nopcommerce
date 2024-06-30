package commons;

import org.openqa.selenium.WebDriver;

import page.object.user.UserHomePageObject;
import page.object.user.UserLoginPageObject;
import page.object.user.UserRegisterPageObject;
import page.object.user.myaccount.UserAddressesPageObject;
import page.object.user.myaccount.UserBackInStockSubscriptionsPageObject;
import page.object.user.myaccount.UserChangePasswordPageObject;
import page.object.user.myaccount.UserCustomerInfoPageObject;
import page.object.user.myaccount.UserDownloadableProductsPageObject;
import page.object.user.myaccount.UserMyProductReviewsPageObject;
import page.object.user.myaccount.UserOrdersPageObject;
import page.object.user.myaccount.UserRewardPointsPageObject;

public class PagesGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static PatternObjectsActions getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserDownloadableProductsPageObject getUserDownloadableProductsPage(WebDriver driver) {
		return new UserDownloadableProductsPageObject(driver);
	}

	public static UserBackInStockSubscriptionsPageObject getUserBackInStockSubscriptionsPage(WebDriver driver) {
		return new UserBackInStockSubscriptionsPageObject(driver);
	}

	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

}
