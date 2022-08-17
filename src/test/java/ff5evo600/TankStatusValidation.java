package ff5evo600;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_Classes.Atg_webconnect_600Page;
import page_Classes.Ffs_600_StatusPage;
import page_Classes.Titan_Login_Page;
import utilities.Screenshot;

public class TankStatusValidation {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./plugins/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
		} else if(browsername.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./plugins/geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS); 
		} else if(browsername.equalsIgnoreCase("edge")) 
		{ 
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\com.gaugetesting\\plugins\\msedgedriver.exe"); 
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); 
		}

		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\com.gaugetesting\\reports\\report.html", true);
		//Browsing URL
		driver.get("https://demooilcompany.mytitan.net/app/ATGWebConnect.aspx?facility=188141");
		driver.manage().window().maximize();
		test = extent.startTest("FFS EVO600 Tanks Status Scenario");
	}


	//Titan Login Screen
	@Test(priority = 1)
	public void titanLoginPage() {

		Titan_Login_Page login = new Titan_Login_Page(driver);
		login.titanloginpageverify();
		test.log(LogStatus.PASS, "Titan Login Page Displayed");
		login.usernameTesxtfield("GaugeTesting2");
		login.passwordTesxtfield("Testing123!");
		login.logonButtton();
	}

	//ATG MANAGEMENT Screen
	@Test(priority = 2)
	public void atgHomescreen() throws InterruptedException {
		Atg_webconnect_600Page atg = new Atg_webconnect_600Page(driver);
		atg.atgpageverify();
		test.log(LogStatus.PASS, "ATG Home Page Displayed");
		Thread.sleep(2000);
		atg.iframehandle(driver);
		atg.iframeusername("admin");
		atg.iframepassword("admin");
		Thread.sleep(2000);
		atg.iframeloginbutton();
	}

	//TANK STATUS Screen
	@Test(priority = 3)
	public void tankStatusVerify() throws IOException, InterruptedException {
		Ffs_600_StatusPage status = new Ffs_600_StatusPage(driver);
		Thread.sleep(2000);
		status.tankstatusverify();
		test.log(LogStatus.PASS, "FFS EVO 600 Tank Status Displayed");
		Screenshot.passedScreenshot(driver, "TankStatus");


	}

	@AfterMethod
	public void reports(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "test case failed in " + result.getName());
			String src = Screenshot.screenshot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(src));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "cases skipped");
		}

		extent.endTest(test);

	}

	@AfterTest
	public void teardown() throws Exception, Exception {
		driver.close();
		extent.flush();
	}

}