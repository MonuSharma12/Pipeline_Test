package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
//		features=".//Features/FileUploadFeature.feature",
//		features={".//Features/ChatFeature.feature",".//Features/FileUploadFeature.feature"},
	features=".//Features/LoginFeature.feature",
//		features=".//Features/AddDealFeature.feature",
//		features=".//Features/AddConnectionFeature.feature",
		// features=".//Features/AddPolicyAdminFeature.feature",
//		features=".//Features/AddPolicyUserFeature.feature",
		glue="StepDefinition",
		dryRun=false,
		monochrome=true,
//		tags="@Order2",
		plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}
		
		)

public class Run extends AbstractTestNGCucumberTests
{
	

}
