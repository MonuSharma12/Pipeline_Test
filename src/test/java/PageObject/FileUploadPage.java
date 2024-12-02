package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage 
{
WebDriver ldriver;
	
	//Constructor
	public FileUploadPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	

	@FindBy(xpath="(//div[@class='icons MuiBox-root css-0'])[3]")//(//div[@class='icons MuiBox-root css-0'])[1]
	WebElement dropdownBtn;
	
	@FindBy(xpath="//div[text()='Financial']")
	WebElement financialOption;
	
	@FindBy(xpath="//button[contains(@class,'left_upload_btn')]")
	WebElement uploadBtn;
	
	////div[@class='Toastify']
	@FindBy(xpath="//div[text()='File Analyzed Successfully.']")//div[text()='Analyzed']
	WebElement analyzedText;
	

	public void clickOnDropdownButton()
	{
		dropdownBtn.click();
	}
	
	public void clickOnFinancialOption()
	{
		financialOption.click();
	}
	
	public void clickOnUploadButton()
	{
		uploadBtn.click();
	}
	
	public String analyzedTextMsg()
	{
		System.out.println("Inside Analyzed....");
		return analyzedText.getText();
		
	}

}
