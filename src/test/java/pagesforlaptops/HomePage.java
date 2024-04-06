package pagesforlaptops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class HomePage extends BaseClass {

	@When("Click the laptops category")
	public void click_the_laptops_category() throws IOException {
		try {
			
			driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Laptops']")).click();
			
			reportStep("Clicking the Laptop Category", "Pass");
			
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-group']/a[text()='Laptops']")));
			
			reportStep("Unable to Click the Laptop Category", "fail");
			
			e.printStackTrace();
			
		}
	}

	@When("Click the first resulting laptop")
	public void click_the_first_resulting_laptop() throws IOException {
		try {
			driver.findElement(By.xpath("//h4[@class='card-title']/a[text()='Sony vaio i5']")).click();
			
			reportStep("Clicking the first resulting laptop", "Pass");
			
		} catch (Exception e) {
			
			WebElement laptop = driver.findElement(By.xpath("//h4[@class='card-title']/a[text()='Sony vaio i5']"));

			wait.until(ExpectedConditions.visibilityOf(laptop)).click();
			
			reportStep("Unable to get the first resulting laptop", "fail");

		}
	}

}
