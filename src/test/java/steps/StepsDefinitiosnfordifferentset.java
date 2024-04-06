package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class StepsDefinitiosnfordifferentset extends BaseClass {
	
	
	@When("Click the first resulting mobile")
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
	
	@When("Entering the names in the name field as(.*)$")
	public void entering_the_names_in_the_name_field(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
	}


	@And("Entering the number in the credit Card number field (.*)$")
	public void enteringCreditCardNumber(String num) {

		driver.findElement(By.id("card")).sendKeys(num);

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
