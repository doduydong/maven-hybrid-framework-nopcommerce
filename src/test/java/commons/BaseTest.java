package commons;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	protected Logger log = LogManager.getLogger(this.getClass());
	private String browserName;

	protected WebDriver initDriver(String browserName, String siteName, String serverName) {
		this.browserName = browserName;
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid");
		}
		log.info("---------- [Run on '" + browserName.toUpperCase() + "' Browser] ----------");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(getPageUrlOf(siteName, serverName));
		return driver;
	}

	protected void quitDriver() {
		driver.manage().deleteAllCookies();
		driver.quit();
		log.info("------------------------- [DONE - " + browserName.toUpperCase() + "] -------------------------");
	}

	private String getPageUrlOf(String siteName, String serverName) {
		if (siteName.toLowerCase().equals("user")) {
			switch (serverName) {
			case "dev":
				return GlobalConstants.USER_DEV_URL;
			case "test":
				return GlobalConstants.USER_TEST_URL;
			case "demo":
				return GlobalConstants.USER_DEMO_URL;
			case "staging":
				return GlobalConstants.USER_STAG_URL;
			case "prod":
				return GlobalConstants.USER_PROD_URL;
			default:
				throw new RuntimeException("'" + serverName.toUpperCase() + "' server is invalid");
			}
		} else if (siteName.toLowerCase().equals("admin")) {
			switch (serverName) {
			case "dev":
				return GlobalConstants.ADMIN_DEV_URL;
			case "test":
				return GlobalConstants.ADMIN_TEST_URL;
			case "demo":
				return GlobalConstants.ADMIN_DEMO_URL;
			case "staging":
				return GlobalConstants.ADMIN_STAG_URL;
			case "prod":
				return GlobalConstants.ADMIN_PROD_URL;
			default:
				throw new RuntimeException("'" + serverName.toUpperCase() + "' server is invalid");
			}
		} else {
			throw new RuntimeException("'" + siteName.toUpperCase() + "' site is invalid");
		}
	}

	protected int getRandomNumber() {
		return new Random().nextInt(99999);
	}

	protected void verify(Object actual, Object expected) {
		if (actual.equals(expected)) {
		} else {
			log.info("-------------------- [FAILED] --------------------");
			throw new RuntimeException("expected [" + expected + "] but found [" + actual + "]");
		}
	}

}
