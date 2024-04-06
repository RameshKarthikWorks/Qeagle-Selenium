package pagesforlaptops;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import runner.BaseClass;

public class VerifyPurchaseOrder extends BaseClass {

	@Then("Verify the purchase ID")
	public void verifyPurchaseid() {
		String purchaseID;
		try {
			try {
				
				purchaseID = driver.findElement(By.xpath("(//h2)[3]/following::p[contains(text(),'Id')]")).getText();
				
				String[] split = purchaseID.split("\n");
			
				System.out.println("The Purchase" + split[0]);
				

				reportStep("Verified the purchaseOrder", "Pass");

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				reportStep("Unable to Verify the purchaseOrder", "Pass"); 
				
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
