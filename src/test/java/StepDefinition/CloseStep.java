package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class CloseStep extends BaseClass
{
	@Then("close browser")
	public void close_browser() {
/*		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		driver.close();
		log.info("Browser closed");

		//driver.quit();
	}
	
	

	
}
