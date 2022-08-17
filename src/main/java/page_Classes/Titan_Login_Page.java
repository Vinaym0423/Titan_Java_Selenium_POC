package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Titan_Login_Page {

	@FindBy(xpath="//input[@placeholder='User Name']")
	WebElement titanusername;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement titanpassword;
	
	@FindBy(xpath="//input[@name='ctl00$Content$logOn']")
	WebElement titanlogonbutton;
	
	public Titan_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void titanloginpageverify()
	{
		boolean validate = titanlogonbutton.isDisplayed();
		if(validate==true)
		{
			System.out.println("Screen Redirected To Titan Login Screen");
		} else {
			System.out.println("Titan Login Page not displayed");
		}
	}
	public void usernameTesxtfield(String username)
	{
		titanusername.sendKeys(username);
	}
	
	public void passwordTesxtfield(String password)
	{
		titanpassword.sendKeys(password);
	}
	
	public void logonButtton()
	{
		titanlogonbutton.click();
	}
	
	//String url= "https://demooilcompany.mytitan.net/auth/LogOn.aspx?ReturnUrl=%2fapp%2fATGWebConnect.aspx%3ffacility%3d185675&facility=185675";
}
