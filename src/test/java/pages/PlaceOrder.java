package pages;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class PlaceOrder  extends BaseClass {

	@And("Click the place Order")
	public void placeOrder() {

		try {
			driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}
	
	@When("Entering the names in the name field as(.*)$")
	public void entering_the_names_in_the_name_field(String name) {
		try {
			driver.findElement(By.id("name")).sendKeys(name);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	@And("Entering the number in the credit Card number field (.*)$")
	public void enteringCreditCardNumber(String num) {

		try {
			driver.findElement(By.id("card")).sendKeys(num);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@And("Click on purchase button")
	public void clickPurchase() {

		try {
			driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}
}
