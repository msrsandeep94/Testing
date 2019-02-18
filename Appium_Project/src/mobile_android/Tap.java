package mobile_android;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class Tap 
{
	public static void main(String[] args) throws Exception
	{
		//start appium server and form URL for it
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		//maintain details base for app & ARD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "1d52d6859804");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		dc.setCapability("noReset", "true");
		//launch app in ARD through appium server
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
			}
		}
		//Automation
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Native View']")));
			//tap an element
			WebElement e=driver.findElement(By.xpath("//*[@text='Native View']"));
			TouchAction ta=new TouchAction(driver);
			ta.tap(ElementOption.element(e)).perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//wait and validation outcome
			try
			{
				if(driver.findElement(By.xpath("//*[@text='Native View Demo']")).isDisplayed())
				{
					System.out.println("test passed");
				}
				else
				{
				System.out.println("test failed");
				}
			}
			catch(Exception ey)
			{
				System.out.println(ey.getMessage());
			}	
		}
		catch(Exception ex)
		{
			System.out.println("Test failed"+ex.getMessage());
		}
		
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	
	}

}
