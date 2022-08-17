package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String screenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/Failedcases/"+screenshotname+".png";
		File finaldes=new File(destination);
		FileUtils.copyFile(src,finaldes);
		return destination;
	}
	
	public static String passedScreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/Passed_Screenshots/"+screenshotname+".png";
		File finaldes=new File(destination);
		FileUtils.copyFile(src,finaldes);
		return destination;
	}
}
