package runner;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {

	public static RemoteWebDriver driver;

	public static WebDriverWait wait;

	public static ExtentReports report;

	public static ExtentTest test;

	public String testCase, testDescription, testAuthor, testCategory;

	@BeforeSuite
	public void startReport() {

		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("./Report/result.html");

		htmlreporter.setAppendExisting(true);

		report = new ExtentReports();

		report.attachReporter(htmlreporter);

	}

	@BeforeClass
	public void assignTestDetails() {

		test = report.createTest(testCase, testDescription);

		test.assignAuthor(testAuthor);

		test.assignCategory(testCategory);

	}

	public int takeSnap() throws IOException {

		int ram = (int) (Math.random()*99999 +99999);

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File desc = new File("./Snaps/img" + ram + ".png");

		FileUtils.copyFile(screenshotAs, desc);

		return ram;

	}

	public void reportStep(String msg, String status) throws IOException {

		if (status.equalsIgnoreCase("Pass")) {
			test.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
		}

		else if (status.equalsIgnoreCase("Fail")) {
			test.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());

			throw new RuntimeException("View Report for more details");

		}

	}

	@BeforeMethod
	public void preConditions() throws IOException {

		// Open Chrome Browser
		driver = new ChromeDriver();

		// maximizing the screen
		driver.manage().window().maximize();

		// appliying the implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// URL to navigate to the demoblaze home page. //
		driver.get("https://demoblaze.com/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@AfterMethod
	public void postConditions() {

		driver.quit();

	}

	@AfterSuite
	public void stopReport() {
		// TODO Auto-generated method stub

		report.flush();
	}

}
