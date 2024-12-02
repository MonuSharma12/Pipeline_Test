package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPolicyAdminPage 
{
      WebDriver ldriver;
	
	//Constructor
	public AddPolicyAdminPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'MuiAvatar-root')]")
	WebElement UserIcon;
	
	@FindBy(xpath="//li[text()='Setup']")
	WebElement Setup; 
	
	
	@FindBy(xpath="//span[text()='Roles']")//(//div[@class='admin_list_text  MuiBox-root css-0'])[2]
	WebElement RolesIcon;
	
	@FindBy(xpath="//button[text()='Add New Policy']")
	WebElement AddNewPolicyBtn;
	
	@FindBy(xpath="//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tzsjye']")
	WebElement Roledrpdn;
	
	
	@FindBy(xpath="//div[text()='Deal']")//(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-1rj4dfd'])[2]
	WebElement Resourcedrpdn;
	
	//label[text()='Deal Name']
	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[3]")//
	WebElement DealNamedrpdn;
	
	//(//div[@role='combobox'])[4]
	@FindBy(xpath="//div[@id='action-select_permission']")//(//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-6oszqx'])[3]
	WebElement Actiondrpdn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement addPolicyBtn;
	
	@FindBy(xpath="//div[text()='Policy added successfully.']")
	WebElement policymsg;
	
	public void clickOnUserIcon()
	{
		UserIcon.click();
	}
	
	public void clickOnSetup()
	{
		Setup.click();
	}
	
	public void clickOnRolesIcon()
	{
		RolesIcon.click();
	}
	
	public void clickOnAddNewPolicyButton()
	{
		AddNewPolicyBtn.click();
	}
	
	public void clickOnRoleDropdown()
	{
		Roledrpdn.click();
	}
	
	public void clickOnResourceDropdown()
	{
		Resourcedrpdn.click();
	}
	
	public void clickOnDealNameDropdown()
	{
		DealNamedrpdn.click();
	}
	
	public void clickOnActionDropdown()
	{
		Actiondrpdn.click();
	}
	
	public void clickOnAddPolicyButton()
	{
		addPolicyBtn.click();
	}
	
	public String verifyAddPolicyMsg()
	{
		return policymsg.getText();
	}

}
