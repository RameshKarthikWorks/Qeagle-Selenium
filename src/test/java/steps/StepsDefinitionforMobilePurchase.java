package steps;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionforMobilePurchase {

	public ChromeDriver driver;

	public WebDriverWait wait;

	@Given("Launch the browser")
	public void launchBrowser() {
		driver = new ChromeDriver();

	}

	@And("Load the Url")
	public void loadtheUrl() {
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@And("Click the first resulting mobile")
	public void clickMobile() {
		driver.findElement(By.xpath("(//h4[@class='card-title']/a)[1]")).click();

	}

	@And("Click the Add to Cart")
	public void addtoCart() {
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

	}
	
	@When("Accept the Alert")
	public void accept_the_alert() {
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}


	@And("Click the cart Option in the Menu")
	public void cartMenu() {

		driver.findElement(By.xpath("//a[text()='Cart']")).click();

	}

	@And("Click the place Order")
	public void placeOrder() {

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

	}

	@And("Entering the names in the name field")
	public void enteringName() {

		driver.findElement(By.id("name")).sendKeys("Ramesh Aravindh");

	}

	@And("Entering the number in the credit Card number field")
	public void enteringCreditCardNumber() {

		driver.findElement(By.id("card")).sendKeys("7885214569874511");

	}

	@And("Click on purchase button")
	public void clickPurchase() {

		driver.findElement(By.xpath("//button[text()='Purchase']")).click();

	}

	@Then("Verify the purchase ID")
	public void verifyPurchaseid() {
		String purchaseID = driver.findElement(By.xpath("(//h2)[3]/following::p[contains(text(),'Id')]")).getText();

		String[] split = purchaseID.split("\n");

		System.out.println("The Purchase" + split[0]);

		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();

	}

}
