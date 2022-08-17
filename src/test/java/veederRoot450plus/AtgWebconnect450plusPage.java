package veederRoot450plus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtgWebconnect450plusPage {

	@FindBy(xpath="//a[.='ATG Management']")
	WebElement atgmanagementtext;
	
	@FindBy(xpath="//input[@class='gwt-TextBox']")
	WebElement veederusername;
	
	@FindBy(xpath="//input[@class='gwt-PasswordTextBox']")
	WebElement veederpassword;
	
	@FindBy(xpath="//button[@class='gwt-Button']")
	WebElement veedersignbutton;
	
	@FindBy(xpath="//span[.=' System Status ']")
	WebElement statustext;
	 
	
	public AtgWebconnect450plusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAtmText()
	{
		String text=atgmanagementtext.getText();
		if(text.equals("ATG Management")) {
			System.out.println("Titan Login successfull ");
		}
	}
	
	public void iframehandle(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}

	public void veederusername(String un)
	{
		veederusername.sendKeys(un);
	}
	
	public void veederpassword(String pwd)
	{
		veederpassword.sendKeys(pwd);
	}
	
	public void veedersiginbutton()
	{
		veedersignbutton.click();
	}
	
	
	}
	
	
	
	

