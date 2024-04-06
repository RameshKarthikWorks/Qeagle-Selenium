package pagesforlaptops;

import java.io.IOException;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class PlaceOrder extends BaseClass {

	@And("Click the place Order")
	public void placeOrder() throws IOException {

		try {

			driver.findElement(By.xpath("//button[text()='Place Order']")).click();

			reportStep("Click to Place Order", "Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			reportStep("Unable to Place Order", "fail");

			e.printStackTrace();
		}

	}

	@When("Entering the names in the name field as(.*)$")
	public void entering_the_names_in_the_name_field(String name) throws IOException {
		try {

			driver.findElement(By.id("name")).sendKeys(name);

			reportStep("Entering the Buyer name", "Pass");

		} catch (Exception e) {

			reportStep("Unable to enter the Buyer name", "fail");

			e.printStackTrace();
		}
	}

	@And("Entering the number in the credit Card number field (.*)$")
	public void enteringCreditCardNumber(String num) throws IOException {

		try {

			driver.findElement(By.id("card")).sendKeys(num);

			reportStep("Entering the Credit Card number", "Pass");

		} catch (Exception e) {

			reportStep("Unable to enter the Credit Card name", "fail");

			e.printStackTrace();
		}

	}

	@And("Click on purchase button")
	public void clickPurchase() throws IOException {

		try {

			driver.findElement(By.xpath("//button[text()='Purchase']")).click();

			reportStep("Click the purchase ", "Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Failed to Click", "fail");

			e.printStackTrace();
		}

	}
}
