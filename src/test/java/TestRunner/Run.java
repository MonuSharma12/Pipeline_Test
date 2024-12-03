package TestRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
//		features=".//Features/FileUploadFeature.feature",
<<<<<<< HEAD
		features={".//Features/ChatFeature.feature",".//Features/FileUploadFeature.feature"},
//		features=".//Features/LoginFeature.feature",
//		features=".//Features/AddDealFeature.feature",
//		features=".//Features/AddConnectionFeature.feature",
//		features=".//Features/AddPolicyAdminFeature.feature",
=======
//		features={".//Features/ChatFeature.feature",".//Features/FileUploadFeature.feature"},
	features=".//Features/LoginFeature.feature",
//		features=".//Features/AddDealFeature.feature",
//		features=".//Features/AddConnectionFeature.feature",
		// features=".//Features/AddPolicyAdminFeature.feature",
>>>>>>> ee8faf2923fc38795c344073214049935b6b85c5
//		features=".//Features/AddPolicyUserFeature.feature",
		glue="StepDefinition",
		dryRun=false,
//		monochrome=true,
//		tags="@Order2",
		plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}
		
		)

public class Run extends AbstractTestNGCucumberTests
{
/*	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	*/
}
