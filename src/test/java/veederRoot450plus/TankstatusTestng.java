
package veederRoot450plus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_Classes.Titan_Login_Page;

public class TankstatusTestng {
public 	 ExtentReports extent;
public	 ExtentTest test;
	WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		extent= new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\com.gaugetesting\\reports\\report.html", true);
		
		System.setProperty("webdriver.chrome.driver", "./plugins/chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 driver.get("https://demooilcompany.mytitan.net/auth/LogOn.aspx?ReturnUrl=%2fapp%2fATGWebConnect.aspx%3ffacility%3d185675&facility=185675");
		 test=extent.startTest("Titan login page");
	}
	
	@Test(priority=1)
	public void titanloginpage()
	{
		test.log(LogStatus.INFO, "titan login page displayed");
		Titan_Login_Page titan=new Titan_Login_Page(driver);
		titan.usernameTesxtfield("GaugeTesting2");
		titan.passwordTesxtfield("Testing123!");
		titan.logonButtton();

	}
	
	@Test(priority=2)
	public void atghomescreen()
	{
		
		AtgWebconnect450plusPage atg=new AtgWebconnect450plusPage(driver);
		atg.verifyAtmText();
		atg.iframehandle(driver);
		atg.veederusername("admin450");
		atg.veederpassword("admin");
		atg.veedersiginbutton();
	}
	
	@Test(priority = 3)
	public void tankstatusverify()
	{
		veederRoot450plus.Vedder450plusStatusTankPage status= new Vedder450plusStatusTankPage(driver);
		status.statusverify();
	}
	
	@AfterMethod
	public void reports(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "test case failed in "+result.getName());
		String src = TankstatusTestng.screenshot(driver, result.getName());
		test.log(LogStatus.FAIL,test.addScreenCapture(src));
		} else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP,"cases skipped");	
		}
		
		extent.endTest(test);
	}
	
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
	
	public static String screenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/failedcasess/"+screenshotname+".png";
		File finaldes=new File(destination);
		FileUtils.copyFile(src,finaldes);
		return destination;
	}
	
	
}
