package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddConnectionPage;
import PageObject.AddDealPage;
import PageObject.AddPolicyAdminPage;
import PageObject.AddPolicyUserPage;
import PageObject.ChatPage;
import PageObject.FileUploadPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

//Child class of Base Class
public class StepDef extends BaseClass
{
	WebElement element;
	Select dropdown;
	
	@Before
	public void setup()
	{
		//properties file initialization
		readConfig=new ReadConfig();
		
		
		
		//initialization of log class
		log=LogManager.getLogger("StepDef");
		
		System.out.println("setup method executed...");
		
		//read browser name from readconfig method
		String browser=readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
		
		
		log.info("Setup1 executed...");
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

			
		loginPg=new LoginPage(driver);
		addDealPg=new AddDealPage(driver);
		fileUploadPg=new FileUploadPage(driver);
		chatPg=new ChatPage(driver);
		addConnectionPg=new AddConnectionPage(driver);
		addPolicyAdminPg=new AddPolicyAdminPage(driver);
		addPolicyUserPg=new AddPolicyUserPage(driver);
		log.info("Chrome browser launched...");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		driver.get(url);
		log.info("url opened...");
	}
	
	
	@When("Click on Login")
	public void click_on_login() {
	    loginPg.clickOnLoginButton();
	    log.info("Clicked on login button...");
	}
	
	
	@When("User enters Email as {string}")
	public void user_enters_email_as(String emailadd) {
		//move on login Window
		String origionalWindow=driver.getWindowHandle();
		Set<String> allPages=driver.getWindowHandles();
		for(String page:allPages)
		{
			driver.switchTo().window(page);
		}
		System.out.println("move to login window");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    loginPg.enterEmail(emailadd);
		log.info("Entered Email Id...");
	}
	
	@When("Click on Next")
	public void click_on_next() {
	    loginPg.clickOnFirstNextButton();
	    log.info("Clicked on First next Button...");
	}
	
	@When("User enters Password as {string}")
	public void user_enters_password_as(String passwordadd) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    loginPg.enterPassword(passwordadd);
	    log.info("Entered Password...");
	}
	
	@When("Click on Next2")
	public void click_on_next2() {
		loginPg.clickOnSecondNextButton();
		log.info("Clicked on Second next Button...");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Login success");
	    
		}
	//////// Login Features //////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		//move on Dash Board
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through the handles and switch to the last one
		for (String windowHandle : allWindowHandles) {
		    driver.switchTo().window(windowHandle);
		}
		
		//page title verify
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			log.warn("Test passed: Login feature :Page title matched.");

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			log.warn("Test Failed: Login feature- page title not matched.");


		}
	}
	
	////// Logout /////
	@When("User select Logout option")
	public void user_select_logout_option() throws InterruptedException {
		Thread.sleep(5000);
		loginPg.clickOnLogout();
		
		log.info("Clicked on Setup option....");
	}
	
	////// Add Deal //////
	@When("User click on M&A Deal Designer")
	public void user_click_on_m_a_deal_designer() {
		addDealPg.clickOnDealDesignButton();
		log.info("Clicked on M@A Deal Designer Button....");
	}
	
	@When("user select Choose deal side Radio button as {string}")
	public void user_select_choose_deal_side_radio_button_as(String dealSide) {
		switchToNewWindow("currentWindow");
		dynamicWebDriverWait(By.xpath("//h6[text()='M&A Deal Designer']"),3);
		staticWait(2000);
		selectRadioButtonByValue(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-9l3uo3']"),dealSide);
		System.out.println("Deal Side Text File:"+ dealSide);
		log.info("Choosed Deal side Radio Button....");
		staticWait(2000);
	}
	
	@When("user select Nature of the Deal Radio button as {string}")
	public void user_select_nature_of_the_deal_radio_button_as(String dealNature) {
		selectRadioButtonByValue(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-9l3uo3']"),dealNature);
		log.info("Choosed Nature Of Deal Radio Button....");
		staticWait(2000);
	}
	
	@When("User enters Deal Name as {string}")
	public void user_enters_deal_name_as(String dealname) {
		addDealPg.entersDealName(dealname);
		log.info("Entered Deal Name...");
	}
	
	@When("user enters Name of the Company as {string}")
	public void user_enters_name_of_the_company_as(String companyname) {
	    addDealPg.entersCompanyName(companyname);
	    log.info("Entered Name of Company...");
	    
	}
	
	@When("user select Industry Type dropdown as {string}")
	public void user_select_industry_type_dropdown_as(String industryType) {
	    addDealPg.clickOnIndustryTypeDropdown();
	    
	    selectOptionByText(By.xpath("//li[@role='option']"),industryType);
	    log.info("Clicked on Industry Type Dropdown...");
	    staticWait(2000);
	}
	
	@When("Click on Create")
	public void click_on_create() {
	    addDealPg.clickOnDealButton();
	    log.info("Clicked on Create Deal Button...");
	}
	
	
	@Then("User can view add deal message {string}")
	public void user_can_view_add_deal_message(String addDealMsg) {
		System.out.println("read text msg from deal add :"+addDealMsg);
		
		dynamicWebDriverWait(By.xpath("//div[text()='Deal Added Successfully']"),5);
		
		 //Text Msg For Validation//Deal Added Successfully
        String actualDealMsg=addDealPg.readAddDealMsg();
        System.out.println("read actual Deal Msg :"+actualDealMsg);
        String expectedDealMsg=addDealMsg;
        
        Assert.assertEquals(expectedDealMsg, actualDealMsg);
        System.out.println("Deal added Msg Verified");
        log.info("Deal Added Successfully...");
	}
	

	
	////////// File Upload ///////
	@When("User click on Dropdown button")
	public void user_click_on_dropdown_button() {
		fileUploadPg.clickOnDropdownButton();
		log.info("Clicked on Alpha Dropdown Arrow...");
	}
	
	
	@When("click on Financial Option")
	public void click_on_financial_option() {
		fileUploadPg.clickOnFinancialOption();
		log.info("Clicked On Financial option...");
	}
	
	@When("click on Upload button")
	public void click_on_upload_button() throws AWTException {
		fileUploadPg.clickOnUploadButton();
		log.info("Clicked on upload button...");
		
		//file upload
				Robot rb=new Robot();
				rb.delay(2000);
				//copy file to clipboard
				StringSelection ss=new StringSelection("C:\\Users\\Mands\\Downloads\\File 19mb.pdf");//20 mbFile
				
//				String filePath="ss";
				
				
				//Toolkit
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				//perform control+V
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
		log.info("File Entered....");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmationmsg) {
         
	        System.out.println("read text from file:"+confirmationmsg);      
	        
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator);
	        dynamicWebDriverWait(By.xpath("//div[text()='File Analyzed Successfully.']"),300);
	        
	        //Text Msg For Validation//File Analyzed Sucessfully.//File Analyzed Sucessfully.
	        String actualMsg=fileUploadPg.analyzedTextMsg();
	        System.out.println("read actualMsg :"+actualMsg);
	        String expectedMsg=confirmationmsg;
	        
	        Assert.assertEquals(expectedMsg, actualMsg);
	        System.out.println("Msg Verified");
//	        Assert.assertTrue("Analyzed Msg Verified", false);
//	        String expectedMsg=confirmationmsg;
//	        String actualMsg=fileUploadPg.analyzedText();
	        
	        log.info("File Uploaded...");
	        System.out.println("File Upload Test Pass................");


	}
	
	//////admin onedrive connection//////
	
	@When("User click on User Icon")
	public void user_click_on_user_icon() {
		addConnectionPg.clickOnUserIcon();
		log.info("Clicked On User Icon....");

	}
	
	@When("User select Setup option")
	public void user_select_setup_option() throws InterruptedException {
		addConnectionPg.clickOnSetup();
		Thread.sleep(5000);
		log.info("Clicked on Setup option....");
	}
	
	@When("click on data")
	public void click_on_data() {
		//move new Window
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through the handles and switch to the last one
		for (String windowHandle : allWindowHandles) {
		    driver.switchTo().window(windowHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		addConnectionPg.clickOnDataIcon();
		log.info("Clicked on Data Button....");
	}
	
	@When("click on Add button")
	public void click_on_add_button() {
		addConnectionPg.clickOnAddButton();
		log.info("Clicked On Add Button....");
	}
	
	@When("User enters Connection Name as {string}")
	public void user_enters_connection_name_as(String connectionName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		addConnectionPg.enterConnectionName(connectionName);
		log.info("Entered Connection Name....");
	}
	
	@When("click on Select Deal dropdown")
	public void click_on_select_deal_dropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		System.out.println("Inside Select deal method");
		
		//click on Select Deal Dropdown
		driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters menu_item css-1km1ehz')]"));
		 // Iterate through the options and select the desired one
		for(WebElement option:options)
		{
			System.out.println("List of deals :"+option.getText());
			if(option.getAttribute("data-value").equals("NewDealTrial"))
			{
				
				option.click();
				break;
			}
		}
		log.info("Entered Select Deal dropdown....");
	}
	
	@When("click on Select Category dropdown")
	public void click_on_select_category_dropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		System.out.println("Inside category method");
		
		//click on Select Deal Dropdown
		driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters menu_item css-1km1ehz')]"));
		 // Iterate through the options and select the desired one
		for(WebElement option:options)
		{
			System.out.println("List of category :"+option.getText());
			if(option.getText().equals("Legal"))
			{
				
				option.click();
				break;
			}
		}
		
	}
	
	@When("click on Data Source dropdown")
	public void click_on_data_source_dropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		System.out.println("Inside category method");
		
		//click on Select Deal Dropdown
		driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[3]")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]"));
		 // Iterate through the options and select the desired one
		for(WebElement option:options)
		{
			System.out.println("List of category :"+option.getText());
			if(option.getText().equals("One Drive"))
			{
				
				option.click();
				break;
			}
		}


	}
	
	@When("click on checkbox")
	public void click_on_checkbox() {
		addConnectionPg.clickOnCheckbox();
		
	}
	
	@When("User Click on Add")
	public void user_click_on_add() {
		addConnectionPg.clickOnSubmitAddButton();
		
	}
	
	//////One Drive Login////////
	@When("User enters One Drive Email as {string}")
	public void user_enters_one_drive_email_as(String UserId) {
		//move new Window
				Set<String> allWindowHandles = driver.getWindowHandles();

				// Iterate through the handles and switch to the last one
				for (String windowHandle : allWindowHandles) {
				    driver.switchTo().window(windowHandle);
				}
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				addConnectionPg.enterOneDriveUserId(UserId);
	}
	
	@When("click on Drive Next button")
	public void click_on_drive_next_button() {
		addConnectionPg.clickOnDriveNextButton();
		
	}
	
	@When("User enters One Drive Password as {string}")
	public void user_enters_one_drive_password_as(String UserPassword) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addConnectionPg.enterOneDrivePassword(UserPassword);
	}
	
	@When("click on Sign In")
	public void click_on_sign_in() {
		addConnectionPg.clickOnDriveSignInButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@When("user click on Decline button No")
	public void user_click_on_decline_button_no() {
		addConnectionPg.clickOnDeclineButtonNO();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/////Select Drive Folders List////
	@When("User Select Folder")
	public void user_select_folder() {
		List<WebElement> folderList=driver.findElements(By.xpath("//input[@name='folder']"));
		// Iterate through the options and select the desired one
				for(WebElement option:folderList)
				{
					System.out.println("List of folders :"+option.getText());
					if(option.getAttribute("value").equals("4EA2FE12BD6289C0!113"))
					{
						
						option.click();
						break;
					}
				}
		
//		addConnectionPg.clickOnDriveFolderList();
	}
	
	@When("click on Save Select Folders")
	public void click_on_save_select_folders() {
		addConnectionPg.clickOnSaveSelectFoldersButton();
	}
	
	//Verification msg
	@Then("User can view Add Connection Message as {string}")
	public void user_can_view_add_connection_message_as(String DriveMsg) {
		System.out.println("read text from file:"+DriveMsg);
		
		dynamicWebDriverWait(By.xpath("//div[text()='OneDrive folders saved successfully!']"),300);
        
        //Text Msg For Validation//OneDrive Msg //OneDrive folders saved successfully!
        String actualMsg=addConnectionPg.verifyDriveMsg();
        System.out.println("read actualMsg :"+actualMsg);
        String expectedMsg=DriveMsg;
        
        Assert.assertEquals(expectedMsg, actualMsg);
        System.out.println("Drive Msg Verified");
	}
	
	@Then("click on close window button")
	public void click_on_close_window_button() {
//		dynamicWebDriverWait(By.xpath("//button[@class='close-button']"),10);
		
		
		addConnectionPg.clickOnCloseWindowButton();

		
	}
	
	@Then("User Select Folder dropdown")
	public void user_select_folder_dropdown() {
		//move on connection window
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through the handles and switch to the last one
		for (String windowHandle : allWindowHandles) {
		    driver.switchTo().window(windowHandle);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addConnectionPg.clickOnSelectFolderDropdownButton();
		driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
		//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']
/*		List<WebElement> folderList=driver.findElements(By.xpath("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz']"));//input[@class='PrivateSwitchBase-input css-1m9pwf3']
		System.out.println("Folder List size:"+folderList.size());
		// Iterate through the options and select the desired one
				for(WebElement option:folderList)
				{
					System.out.println("List of folders :"+option.getText());
					if(option.getText().equals("HARRISON"))
					{
						if(!option.isSelected())
						{
						  option.click();
						  System.out.println("Checkbox with value 'HARRISON' is selected.");
						}
						else
						{
							System.out.println("Checkbox with value 'HARRISON' is already selected.");
						}
						break;
					}
				}  */
				System.out.println("select option ::");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//outside click
				driver.findElement(By.xpath("//span[text()='Data']")).click();
//				System.out.println("click outside  ::");
	}  
	
	@Then("select Frequency dropdown")
	public void select_frequency_dropdown() {
	    addConnectionPg.clickOnFrequencyDropdown();
	    List<WebElement> frequencyList=driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]"));
		// Iterate through the options and select the desired one
				for(WebElement option:frequencyList)
				{
					System.out.println("List of frequencyList :"+option.getText());
					if(option.getText().equals("Daily"))
					{
						
						option.click();
						break;
					}
				}
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addConnectionPg.clickOnUserIcon();
	}
	
	@Then("select Data Type To Sync")
	public void select_data_type_to_sync() {
//	    addConnectionPg.clickOnDataTypeSyncDropdown();
//	    driver.findElement(By.xpath("(//div[@class='MuiListItemText-root css-1tsvksn'])[1]")).click();
/*	    List<WebElement> DataTypeSyncList=driver.findElements(By.xpath("(//div[@class='MuiListItemText-root css-1tsvksn'])[1]"));
		// Iterate through the options and select the desired one
				for(WebElement option:DataTypeSyncList)
				{
					System.out.println("List of DataTypeSync List :"+option.getText());
					if(option.getText().equals("pdf"))
					{
						
						option.click();
						break;
					}
				}
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addConnectionPg.clickOnUserIcon();
				*/
	} 
	
	@Then("select Duplicate File Handling dropdown")
	public void select_duplicate_file_handling_dropdown() {
/*		addConnectionPg.clickOnDuplicateFileHandling();
		System.out.println("click Duplicate File Handling");
		List<WebElement> DuplicateFileList=driver.findElements(By.xpath("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters menu_item css-1km1ehz']"));
		// Iterate through the options and select the desired one
				for(WebElement option:DuplicateFileList)
				{
					System.out.println("List of Duplicate File Handling List :"+option.getText());
					if(option.getText().equals("Overwrite"))
					{
						
						option.click();
						break;
					}
				}
				
				addConnectionPg.clickOnUserIcon();
				*/
	}
	
	@Then("on Recursive Sync toggle button")
	public void on_recursive_sync_toggle_button() {
	    addConnectionPg.clickOnRecursiveSyncToggleButton();
	}
	
	@Then("on Sync Notification toggle button")
	public void on_sync_notification_toggle_button() {
	    addConnectionPg.clickOnSyncNotificationToggleButton();
	}
	
	@Then("on Error Notification toggle button")
	public void on_error_notification_toggle_button() {
	    addConnectionPg.clickOnErrorNotificationToggleButton();
	}
	
	@Then("user click on Save button")
	public void user_click_on_save_button() {
	    addConnectionPg.clickOnSaveButton();
	}
	
	////////  Add New Policy Admin ////////
	
	@When("click on Roles")
	public void click_on_roles() throws InterruptedException {
		//move new Window
				Set<String> allWindowHandles = driver.getWindowHandles();

				// Iterate through the handles and switch to the last one
				for (String windowHandle : allWindowHandles) {
				    driver.switchTo().window(windowHandle);
				}
				Thread.sleep(2000);
		addPolicyAdminPg.clickOnRolesIcon();
		log.info("Clicked on Roles Icon....");
		
	}
	
	@When("User click on Add New Policy button")
	public void user_click_on_add_new_policy_button() {
		dynamicWebDriverWait(By.xpath("//button[text()='Add New Policy']"),30);
		addPolicyAdminPg.clickOnAddNewPolicyButton();
		log.info("Clicked on Add New Policy Button....");
	}
	
	@When("select Role dropdown as {string}")
	public void select_role_dropdown_as(String role) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		addPolicyAdminPg.clickOnRoleDropdown();
		List<WebElement> RoleList=driver.findElements(By.xpath("//li[@role='option']"));
		// Iterate through the options and select the desired one
				for(WebElement option:RoleList)
				{
					System.out.println("List of Role :"+option.getText());
					if(option.getText().equals(role))
					{
						
						option.click();
						break;
					}
				}
		
	    log.info("Clicked on Roll dropdown....");
	}
	
	@When("select Resource as {string}")
	public void select_resource_as(String resource) {
		addPolicyAdminPg.clickOnResourceDropdown();
		
		List<WebElement> ResourceList=driver.findElements(By.xpath("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters Mui-selected MuiMenuItem-root MuiMenuItem-gutters Mui-selected css-1km1ehz']"));//li[@role='option']
		// Iterate through the options and select the desired one
				for(WebElement option:ResourceList)
				{
					System.out.println("List of Rsource :"+option.getText());
					if(option.getText().equals(resource))
					{
						
						option.click();
						System.out.println("Select Deal Inside test..");
						break;
					}
				}
		
		log.info("Clicked on Resource dropdown....");
		
	}
	
	@When("select Deal Name as {string}")
	public void select_deal_name_as(String dealName)  {
		addPolicyAdminPg.clickOnDealNameDropdown();
		List<WebElement> DealNameList=driver.findElements(By.xpath("//li[@role='option']"));
		// Iterate through the options and select the desired one
				for(WebElement option:DealNameList)
				{
					System.out.println("List of Deal Name :"+option.getText());
					if(option.getText().equals(dealName))
					{
						
						option.click();
						break;
					}
				}   
				
		log.info("Clicked on Deal Name dropdown....");
		
	}
	
	@When("select Action as {string}")
	public void select_action_as(String action)  {
		addPolicyAdminPg.clickOnAddPolicyButton();
		System.out.println("click on action..");
/*		List<WebElement> ActionList=driver.findElements(By.xpath("//li[@role='option']"));
		// Iterate through the options and select the desired one
				for(WebElement option:ActionList)
				{
					System.out.println("List of Action :"+option.getText());
					if(option.getText().equals(action))
					{
						
						option.click();
						break;
					}
				}   */
			
		//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]
/*		selectOptionByText(By.xpath("//li[@role='option']"),action);
		System.out.println("Read dropdown List");
		log.info("Clicked on Action dropdown....");
	*/	staticWait(5000);
	}
	
	
	@When("user click on Add Policy button") 
	public void user_click_on_add_policy_button() throws InterruptedException {
		addPolicyAdminPg.clickOnAddPolicyButton();
		log.info("Clicked on Add Policy Button....");
//		Thread.sleep(2000);
	}
	
	///Verify add policy msg
	@Then("user can view msg as {string}")
	public void user_can_view_msg_as(String addPolicyMsg) throws InterruptedException {
		System.out.println("read data from file:"+addPolicyMsg);
        dynamicWebDriverWait(By.xpath("//div[text()='Policy added successfully.']"),3);
        
        //Text Msg For Validation//OneDrive Msg //OneDrive folders saved successfully!
        String actualMsg=addPolicyAdminPg.verifyAddPolicyMsg();
        System.out.println("read actualMsg :"+actualMsg);
        String expectedMsg=addPolicyMsg;
        
        Assert.assertEquals(expectedMsg, actualMsg);
        System.out.println("add policy Msg Verified");
        log.info("Verify Add Policy Msg....");
        
	}
	
	///////Add Policy User///////
	
	@When("Select User Radio button")
	public void select_user_radio_button() {
	    addPolicyUserPg.clickOnUserRadioButton();
	    log.info("Clicked on user Radio Button....");
	}
	
	@When("select UserName dropdown as {string}")
	public void select_user_name_dropdown_as(String username) {
		addPolicyUserPg.clickOnUserNameDropdown();
/*		List<WebElement> UserNameList=driver.findElements(By.xpath("//li[@role='option']"));
		// Iterate through the options and select the desired one
				for(WebElement option:UserNameList)
				{
					System.out.println("List of User Name :"+option.getText());
					if(option.getText().equals(username))
					{
						
						option.click();
						break;
					}
				}
				*/
		selectOptionByText(By.xpath("//li[@role='option']"),username);
				log.info("Clicked on user Name dropdown....");
	}
	
	
	
	///////// Chat Feature //////
	@When("User enters Question as {string}")
	public void user_enters_question_as(String questionadd) {
		
		//move on Dash Board

		switchToNewWindow("currentWindow");

		staticWait(2000);
		chatPg.enterQuery(questionadd);
	       log.info("Question entered...");
		
	}
	
	@When("Click on Search button")
	public void click_on_search_button() {
	   chatPg.clickOnQuerySearchButton();
		log.info("clicked on question search button...");
		
		dynamicWebDriverWait(By.xpath("(//*[name()='svg'][@aria-label='Regenerate'])[last()]"),120);
		System.out.println("Wait for Max 120 Seconds......");
	}
	
	////// copy Answer //////
	@When("click on copy icon")
	public void click_on_copy_icon() {
	    chatPg.clickOnCopyIcon();
	    log.info("Clicked on copy Icon....");
//		inspectLastElement(driver,By.xpath("//*[name()='svg'][@aria-label='Copy']")).click();
		
	}
	///// Like Answer /////
	@When("click on Like Icon")
	public void click_on_like_icon() {
	    chatPg.clickOnLikeIcon();
	    log.info("Clicked on Like Icon....");
	}
	///// Dislike Answer ////
	@When("click on DisLike Icon")
	public void click_on_dis_like_icon() {
	    chatPg.clickOnDisLikeIcon();
	    log.info("Clicked on DisLike Icon....");
	}
	
	//// Regenerate Answer //////
	@When("click on Regenerate Icon")
	public void click_on_regenerate_icon() {
	    chatPg.clickOnRegenerateIcon();
	    dynamicWebDriverWait(By.xpath("(//*[name()='svg'][@aria-label='Regenerate'])[last()]"),120);
	    log.info("Clicked on Regenerate Icon....");
	}
	
	
	@After
	public void teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "D:\\Shivam Download\\Eclipse Workspace\\CucumberFramework\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}
	

	}
	
	

