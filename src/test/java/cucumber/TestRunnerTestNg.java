package cucumber;

import io.cucumber.testng.CucumberOptions;



import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/EcommerceAppCheckoutPage.feature",
		monochrome = true,
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "json:target/cucumber-reports/",
                "html:target/cucumber-reports.html"},
		glue={"stepDefinitions"},
		tags= "@Smoke"
		)

public class TestRunnerTestNg extends AbstractTestNGCucumberTests{

}
