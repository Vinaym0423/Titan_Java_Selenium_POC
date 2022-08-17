package veederRoot450plus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import page_Classes.Titan_Login_Page;
import utilities.Browsername;

public class TankStatusTest {
static WebDriver driver;
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver= new ChromeDriver();

	 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 Titan_Login_Page login = new Titan_Login_Page(driver);
	AtgWebconnect450plusPage atg=new AtgWebconnect450plusPage(driver);
	Vedder450plusStatusTankPage status=new Vedder450plusStatusTankPage(driver);
	
	//Browser url
	driver.get("https://demooilcompany.mytitan.net/auth/LogOn.aspx?ReturnUrl=%2fapp%2fATGWebConnect.aspx%3ffacility%3d185675&facility=185675");
	
	//Titan login page
	login.usernameTesxtfield("GaugeTesting2");
	login.passwordTesxtfield("Testing123!");
	login.logonButtton();
	
	
	
	  //ATG Management screen atg.verifyAtmText(); Thread.sleep(5000);
	  atg.iframehandle(driver);
	  atg.veederusername("admin450");
	  atg.veederpassword("admin"); 
	  atg.veedersiginbutton();
	  
	  //Tank Status Screen 
	  status.statusverify();
	 TankStatusTest tr= new TankStatusTest();
	String path = tr.screenshot(driver, "veeder");
	System.out.println(path);
	 
	  Thread.sleep(4000);
	driver.close();
	

}



public	String screenshot(WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
File src= ts.getScreenshotAs(OutputType.FILE);
	String destination= System.getProperty("user.dir")+"/failedcasess/"+screenshotname+".png";
	File finaldes=new File(destination);
	FileUtils.copyFile(src,finaldes);
	return destination;
}
}
