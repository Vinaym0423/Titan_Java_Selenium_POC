package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ffs_600_StatusPage {
@FindBy(xpath="(//a[@href='https://demooilcompany.mytitan.net/proxy/188141/tg/fms-tank-status/t/1'])[1]")
WebElement statusverify;

public Ffs_600_StatusPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void tankstatusverify()
{
	String verify = statusverify.getText();
	if(verify.contains("Tank")) {
		System.out.println("Tank Status page is displayed");
	}
}
}
