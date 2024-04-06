package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class AddtoCart  extends BaseClass {

	@And("Click the Add to Cart")
	public void addtoCart() {
		try {
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@When("Accept the Alert")
	public void accept_the_alert() {
		Alert alert ;

		try {
		     driver.switchTo().alert().accept();
			
		} catch (UnhandledAlertException e) {

			alert = driver.switchTo().alert();
			wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
	
				}

	}

	@And("Click the cart Option in the Menu")
	public void cartMenu() {

		try {
			driver.findElement(By.xpath("//a[text()='Cart']")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
