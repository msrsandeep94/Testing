package mobile_android;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

public class LongPress            //no012+4
{
	public static void main(String[] args) throws Exception
	{
		//start appium server and form URL for it
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		//maintain details base for app & ARD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "1d52d6859804");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("noReset", "true");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
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
			//come to home
			Thread.sleep(10000);
			KeyEvent k=new KeyEvent(AndroidKey.HOME);
			driver.pressKey(k);
			Thread.sleep(10000);
			//Horizontal swipe
			
			
			
			//long press on bit torrent
			WebElement e=driver.findElement(By.xpath("//*[content-desc='BitTorrent']"));
			TouchAction ta=new TouchAction(driver);
			ta.longPress(ElementOption.element(e)).perform();
			Thread.sleep(10000);
			try
			{
				if(driver.findElement(By.xpath("//*[resourse-id='com.miui.home:id/trash']")).isDisplayed())
				{
					System.out.println("Test passed");
				} 
				else
				{
					System.out.println("Test failed");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		
		Thread.sleep(5000);
		//back to work with app specified in capabilities
		driver.resetApp();
		driver.closeApp();
		}
		catch(Exception ey)
		{
			System.out.println(ey.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
