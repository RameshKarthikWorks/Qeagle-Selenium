package pagesforlaptops;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class AddtoCart extends BaseClass {

	@And("Click the Add to Cart")
	public void addtoCart() throws IOException {

		try {
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

			reportStep("Clicking the AddtoCart Button", "Pass");
		} catch (Exception e) {

			reportStep("Failed to click the AddtoCart Button", "fail");
			e.printStackTrace();
		}

	}

	@When("Accept the Alert")
	public void accept_the_alert() throws IOException, InterruptedException {
		Alert alert ;
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			
			alert=driver.switchTo().alert();
			
			alert.accept();

			reportStep("Accepting the Alert", "Pass");

		} catch (UnhandledAlertException e) {
			
			wait.until(ExpectedConditions.alertIsPresent());

			alert = driver.switchTo().alert();
	
	        alert.accept();

			reportStep("Failed to accept the Alert", "fail");

			e.printStackTrace();
		}

	}

	@And("Click the cart Option in the Menu")
	public void cartMenu() throws IOException {

		try {

			driver.findElement(By.xpath("//a[text()='Cart']")).click();

			reportStep("Click the Cart", "Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			reportStep("Failed to click the Cart", "fail");

			e.printStackTrace();
		}

	}
}
