package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsername {


	WebDriver driver;


	
	public WebDriver setup(String browsername) {
	
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./plugins/chromedriver.exe");
		this.	driver= new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS); 
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./plugins/geckodriver.exe");
		this.	driver= new FirefoxDriver(); 
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); 
		} else { 
			System.setProperty("webdriver.msedge.driver","C:\\Users\\Admin\\eclipse-workspace\\com.gaugetesting\\plugins\\msedgedriver.exe");
	this.	driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); 
		}
		
		return driver;
	}



}
