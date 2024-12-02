package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddConnectionPage 
{
WebDriver ldriver;
	
	//Constructor
	public AddConnectionPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'MuiAvatar-root')]")
	WebElement UserIcon;
	
	@FindBy(xpath="//li[text()='Setup']")
	WebElement Setup;
	
	@FindBy(xpath="//span[text()='Data']")
	WebElement DataIcon;
	
	@FindBy(xpath="//span[text()='Add']")
	WebElement AddBtn;
	
	@FindBy(xpath="//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
	WebElement ConnectionName;
	
	@FindBy(xpath="//label[@id='deal-label']")
	WebElement SelectDeal;
	
	@FindBy(xpath="//label[@id='category-label']")
	WebElement SelectCategory;
	
	@FindBy(xpath="//label[@id='data-source-label']")
	WebElement DataSource;
	
	@FindBy(xpath="//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	WebElement newActCheckbox;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement submitAddBtn;
	
	@FindBy(name="loginfmt")
	WebElement driveUserId;
	
	@FindBy(id="idSIButton9")
	WebElement nextBtn;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement drivePassword;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement driveSignIn;
	
	@FindBy(xpath="//button[@id='declineButton']")
	WebElement declineBtn;
	
	
	@FindBy(xpath="//div[@id='folders']")//input[@name='folder']
	WebElement driveFolderList;
	
	@FindBy(xpath="//button[@id='save_folders']")
	WebElement SaveSelectFoldersBtn;
	
	@FindBy(xpath="//div[text()='OneDrive folders saved successfully!']")
	WebElement oneDriveMsg;
	
	@FindBy(xpath="//button[@class='close-button']")
	WebElement closeWindowBtn;
	
	
	@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']")
	WebElement selectFolderBtn;
	
	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[4]")
	WebElement frequency;
	
	//(//div[@class='MuiSelect-select MuiSelect-outlined MuiSelect-multiple MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]
	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiSelect-multiple MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]")//
	WebElement DataTypeSync;
	
	//(//div[@role='combobox'])[7]
	@FindBy(xpath="(//div[contains(@class, 'MuiFormControl-root') and contains(@class, 'form-control') and contains(@class, 'css-13sljp9')])[7]")//
	WebElement duplicateFileHandling;
	
	@FindBy(xpath="(//span[@class='MuiSwitch-thumb css-19gndve'])[1]")//input[contains(@type,'checkbox')]")
	WebElement RecursiveSyncTgl;
	
	@FindBy(xpath="(//input[contains(@type,'checkbox')])[2]")
	WebElement SyncNotificationTgl;
	
	@FindBy(xpath="(//input[contains(@type,'checkbox')])[3]")
	WebElement ErrorNotificationTgl;
	
	@FindBy(xpath="(//button[text()='Save'])[2]")
	WebElement SaveBtn;
	
	public void clickOnUserIcon()
	{
		UserIcon.click();
	}
	
	public void clickOnSetup()
	{
		Setup.click();
	}
	
	public void clickOnDataIcon()
	{
		DataIcon.click();
	}
	
	public void clickOnAddButton()
	{
		AddBtn.click();
	}
	
	public void enterConnectionName(String connName)
	{
		ConnectionName.sendKeys(connName);
	}
	
	public void clickOnSelectDealDropdown()
	{
		SelectDeal.click();
	}
	
	public void clickOnSelectCategoryDropdown()
	{
		SelectCategory.click();
	}
	
	public void clickOnDataSourceDropdown()
	{
		DataSource.click();
	}
	
	public void clickOnCheckbox()
	{
		newActCheckbox.click();
	}
	
	public void clickOnSubmitAddButton()
	{
		submitAddBtn.click();
	}
	
	public void enterOneDriveUserId(String driveId)
	{
		driveUserId.sendKeys(driveId);
	}
	
	public void clickOnDriveNextButton()
	{
		nextBtn.click();
	}
	
	public void enterOneDrivePassword(String drivePass)
	{
		drivePassword.sendKeys(drivePass);
	}
	
	public void clickOnDriveSignInButton()
	{
		driveSignIn.click();
	}
	
	public void clickOnDeclineButtonNO()
	{
		declineBtn.click();
	}
	
	public void clickOnDriveFolderList()
	{
		driveFolderList.click();
	}
	
	public void clickOnSaveSelectFoldersButton()
	{
		SaveSelectFoldersBtn.click();
	}
	
	public String verifyDriveMsg()
	{
		System.out.println("Inside Drive Msg");
		return oneDriveMsg.getText();
	}
	
	public void clickOnCloseWindowButton()
	{
		closeWindowBtn.click();
	}
	
	public void clickOnSelectFolderDropdownButton()
	{
		selectFolderBtn.click();
	}
	
	public void clickOnFrequencyDropdown()
	{
		frequency.click();
	}
	
	public void clickOnDataTypeSyncDropdown()
	{
		DataTypeSync.click();
	}
	
	public void clickOnDuplicateFileHandling()
	{
		duplicateFileHandling.click();
	}
	
	public void clickOnRecursiveSyncToggleButton()
	{
		RecursiveSyncTgl.click();
	}
	
	public void clickOnSyncNotificationToggleButton()
	{
		SyncNotificationTgl.click();
	}
	
	public void clickOnErrorNotificationToggleButton()
	{
		ErrorNotificationTgl.click();
	}
	
	public void clickOnSaveButton()
	{
		SaveBtn.click();
	}

}
