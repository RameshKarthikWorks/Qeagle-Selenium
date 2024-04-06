package day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcel;

public class ProjectSpecification {

	public RemoteWebDriver driver;

	public WebDriverWait wait;

	public String filename;

	@Parameters({ "url", "Browser" })
	@BeforeMethod
	public void preConditions(String url, String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			// Open Chrome Browser
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			// Open Firefox Browser
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("Edge")) {

			// Open EdgeBrowser
			driver = new EdgeDriver();
		}

		// maximizing the screen
		driver.manage().window().maximize();

		// appliying the implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// URL to navigate to the demoblaze home page. //
		driver.get("https://demoblaze.com/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@DataProvider(name ="sendData")
	public String[][] sendData() throws IOException {
		return ReadExcel.readExcel(filename);
	}

	@AfterMethod
	public void postConditions() {

		driver.quit();

	}

}
