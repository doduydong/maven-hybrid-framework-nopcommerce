package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.BaseTest;
import commons.GlobalConstants;

public class ExtentReportsListener implements ITestListener {
	private ExtentSparkReporter sparkReporter;
	private ExtentReports extentReports;
	private ExtentTest test;
	private String reportName;

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getName() + " [PASSED]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getName() + " [PASSED]");
		test.log(Status.INFO, result.getThrowable().getMessage());
		test.addScreenCaptureFromBase64String("data:image/png;base64," + ((TakesScreenshot) ((BaseTest) result.getInstance()).getDriver()).getScreenshotAs(OutputType.BASE64));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, result.getName() + " [SKIPPED]");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		XmlTest xmlTest = context.getCurrentXmlTest();
		String browser = xmlTest.getParameter("browser");
		String site = xmlTest.getParameter("site");
		String server = xmlTest.getParameter("server");
		reportName = "report-" + new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date()) + "-" + browser + "-" + site + "-" + server + ".html";
		sparkReporter = new ExtentSparkReporter(GlobalConstants.EXTENT_REPORTS_PATH + reportName);
		extentReports = new ExtentReports();

		sparkReporter.config().setDocumentTitle("nopCommerce Automation Report");
		sparkReporter.config().setReportName("nopCommerce Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project", "nopCommerce");
		extentReports.setSystemInfo("Browser", browser);
		extentReports.setSystemInfo("Site", site);
		extentReports.setSystemInfo("Server", server);
		extentReports.setSystemInfo("SDET", GlobalConstants.USER_NAME);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		File reportsFile = new File(GlobalConstants.EXTENT_REPORTS_PATH + reportName);
		try {
			Desktop.getDesktop().browse(reportsFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
