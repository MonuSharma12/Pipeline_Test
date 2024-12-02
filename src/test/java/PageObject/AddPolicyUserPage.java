package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPolicyUserPage 
{
     WebDriver ldriver;
	
	//Constructor
	public AddPolicyUserPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//input[@value='user']")
	WebElement UserRadioBtn;
	
	//label[text()='Username']
	@FindBy(xpath="(//div[@role='combobox'])[1]")//
	WebElement userNamedrpdn;
	
	public void clickOnUserRadioButton()
	{
		UserRadioBtn.click();
	}
	
	public void clickOnUserNameDropdown()
	{
		userNamedrpdn.click();
	}

}
