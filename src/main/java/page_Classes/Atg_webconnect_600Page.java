package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Atg_webconnect_600Page {


	@FindBy(xpath="//a[.='ATG Web Connect']")
	WebElement  atgtext;
	
	@FindBy(xpath="//input[@placeholder='User']")
	WebElement iframeusertext ;   
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement iframepasword ;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton ;
	
	
	
	
	public Atg_webconnect_600Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void iframehandle(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	public void atgpageverify()
	{
		String verify="ATG Web Connect";
		String verify2=atgtext.getText();
		if(verify.equalsIgnoreCase(verify2))
		{
			System.out.println("ATG Web Connect Page Displayed");
		}
	}
	public void iframeusername(String un)
	{
		iframeusertext.sendKeys(un);
	}
	
	public void iframepassword(String pwd)
	{
		iframepasword.sendKeys(pwd);
	}
	
	public void iframeloginbutton()
	{
	 loginbutton.click();
	}
	
	

	
	
	
	
}
