package veederRoot450plus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vedder450plusStatusTankPage {

	@FindBy(xpath="//span[.=' System Status ']")
	WebElement statustext;
	
	public Vedder450plusStatusTankPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void statusverify()
	{
	String text= statustext.getText();
	if(text.contains("System Status")) {
		System.out.println("Tank status successfully dispalyed");
	}
}
	
	public String screenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/failedcasess/"+screenshotname+".png";
		File finaldes=new File(destination);
		FileUtils.copyFile(src,finaldes);
		return destination;
	}
}