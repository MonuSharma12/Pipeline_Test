package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage 
{
WebDriver ldriver;
	
	//Constructor
	public ChatPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}
	////textarea[@placeholder='Enter your M&A Query']
	@FindBy(xpath="//textarea[@placeholder='Enter your M&A Query']") //(//textarea[@placeholder='Enter your M&A Query'])[1]
	WebElement query;
	
	////*[name()='circle' and contains(@cx,'26')]
	@FindBy(xpath="//span[@id='chat_Button']")////div[@class='input_field']//*[name()='path'][1]
	WebElement questionSearchBtn;
	
	@FindBy(xpath="(//*[name()='svg'][@aria-label='Copy'])[last()]")
	WebElement copyIcon;
	
	@FindBy(xpath="(//*[name()='svg'][@aria-label='Like'])[last()]")
	WebElement LikeIcon;
	
	@FindBy(xpath="(//*[name()='svg'][@aria-label='Dislike'])[last()]")
	WebElement DislikeIcon;
	
	@FindBy(xpath="(//*[name()='svg'][@aria-label='Regenerate'])[last()]")
	WebElement RegenerateIcon;
	
	public void enterQuery(String questionAdd)
	{
		query.sendKeys(questionAdd);
	}
	
	public void clickOnQuerySearchButton()
	{
		questionSearchBtn.click();
	}
	
	public void clickOnCopyIcon()
	{
		copyIcon.click();
	}
	
	public void clickOnLikeIcon()
	{
		LikeIcon.click();
	}
	
	public void clickOnDisLikeIcon()
	{
		DislikeIcon.click();
	}
	
	public void clickOnRegenerateIcon()
	{
		RegenerateIcon.click();
	}

}
