package pages;

import org.openqa.selenium.By;
import io.cucumber.java.en.When;
import runner.BaseClass;

public class HomePage extends BaseClass{
	

	@When("Click the first resulting mobile")
	public void clickMobile() {
		driver.findElement(By.xpath("(//h4[@class='card-title']/a)[1]")).click();

	}

}
