package day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomatingPlainScript {

	/**
	 * 1. Login into ‘https://demoblaze.com/’: Open your web browser and enter the
	 * URL to navigate to the demoblaze home page. 
	
	  2. Click the resulting 'mobile
	 * phone': From the home page, click on the first resulting mobile phone. 
	
	 * 3.Click 'Add to cart': On the product detail page for the selected mobile
	 * phone, look for the 'Add to cart' button. Click this button to add the mobile
	 * phone to your shopping cart. 
	 * 
	 * 4. Accept the 'alert': After clicking 'Add to
	 * cart', an alert dialog box will appear confirming that the item has been
	 * added to the cart. Click 'OK' to proceed. 

	 * 5. Click the 'Cart' link: Navigate
	 * to the 'Cart' by clicking on the cart icon or link. This will take you to the
	 * shopping cart page where you can see the items you've added. 
	 
	 * 6. Click 'Place
	 * Order': Inside the Cart, locate and click on the 'Place Order' button. This
	 * action will open a new form where you will enter your payment and shipping
	 * information. 
	 
	 * 7. Type in the 'name' and the 'credit card number': In the
	 * 'Place Order' form, fill in the required fields, including your name and
	 * credit card number. 
	
	 * 8. Click the 'Purchase' button: After filling in all the
	 * required details on the 'Place Order' form, click the 'Purchase' button to
	 * complete your order. 
	 
	 * 9. Read the 'Order ID' and print it in the console: Upon
	 * successful completion of the purchase, a confirmation dialog or page will
	 * appear displaying your 'Order ID'. Note down or copy this Order ID and print
	 * it in the console for verification purposes
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Open your web browser and enter the 
		WebDriver driver = new ChromeDriver();
		
		//maximizing the screen 
		driver.manage().window().maximize();
		
		//appliying the implict wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//URL to navigate to the demoblaze home page. //
		driver.get("https://demoblaze.com/");
		
		//click on the first resulting mobile phone. //
		driver.findElement(By.xpath("(//h4[@class='card-title']/a)[1]")).click();
		
		//click Add to cart' button//
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		
		// Applying the Explict wait for the Alert function to be automated
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		// Accepting the Alert
		alert.accept();
		
		//click the cart option in Menu 
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		
		
		// click Place Order button 
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		// Filling the Name
		driver.findElement(By.id("name")).sendKeys("Ramesh Aravindh");
		
		
		//Filling the Credit Card Number
		driver.findElement(By.id("card")).sendKeys("7885214569874511");
		
		// Click purchase
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		
		// Getting the Purchase ID 
		String purchaseID = driver.findElement(By.xpath("(//h2)[3]/following::p[contains(text(),'Id')]")).getText();
		
		String[] split = purchaseID.split("\n"); 
		
		System.out.println("The Purchase"+split[0]);
		
		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
		
		

	}

}
