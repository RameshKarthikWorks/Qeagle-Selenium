package runner;

import org.testng.annotations.BeforeTest;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Purchaselaptop.feature", glue = "pagesforlaptops", monochrome = true, publish = true)
public class RunnerClass extends BaseClass {

	@BeforeTest
	public void setValues() {

		testCase = "Verify the Ecommerce Website";

		testDescription = "Buy a laptop and verify Purchase Order";

		testAuthor = "Ramesh Aravindh";

		testCategory = "Functional testing";

	}

}
