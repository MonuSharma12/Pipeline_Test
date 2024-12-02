package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDealPage 
{
	WebDriver ldriver;
	
	//Constructor
	public AddDealPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[text()='M&A Deal Designer']")
	WebElement DealDesignerBtn;
	
	//(//div[@role='radiogroup'])[1]
	@FindBy(xpath="//span[normalize-space()='Sell Side']")////div[@class='MuiFormGroup-root MuiFormGroup-row MuiRadioGroup-root MuiRadioGroup-row css-p58oka']//input[@type='radio']
	WebElement dealSide;
	
	@FindBy(xpath="(//div[@role='radiogroup'])[2]")//Deal Added Successfully
	WebElement natureofDeal;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement dealName;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement companyName;
	
	@FindBy(xpath="//div[@role='combobox']")
	WebElement industryTypedrpdn;
	
	@FindBy(xpath="//button[text()='+ Create']")
	WebElement createBtn;
	
	@FindBy(xpath="//div[text()='Deal Added Successfully']")//Deal Added Successfully
	WebElement addDealMsg;
	
	public void clickOnDealDesignButton()
	{
		DealDesignerBtn.click();
	}
	
	public void chooseDealSide()
	{
		dealSide.click();
	}
	
	public void chooseNatureOfDeal()
	{
		natureofDeal.click();
	}
	
	public void entersDealName(String DealName)
	{
		dealName.sendKeys(DealName);
	}
	
	public void entersCompanyName(String CmpnyName)
	{
		companyName.sendKeys(CmpnyName);
	}
	
	public void clickOnIndustryTypeDropdown()
	{
		industryTypedrpdn.click();
	}
	
	public void clickOnDealButton()
	{
		createBtn.click();
	}
	
	public String readAddDealMsg()
	{
		System.out.println("Inside Add deal....");
		return addDealMsg.getText();
	}

}
