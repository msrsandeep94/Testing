package mobile_android;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Lockscreen
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
		KeyEvent k=new KeyEvent(AndroidKey.HOME);
		driver.pressKey(k);
		Thread.sleep(5000);
		driver.openNotifications();
		WebElement e=driver.findElement(By.xpath("//*[@content-desc='Clear all notifications.']"));
		String f=e.getAttribute("enabled");
		if(f.equals(true))
		{
			e.click();
		}
		else
		{
			driver.pressKey(k);
		}
		Thread.sleep(000);
		//ConnectionState con=new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
		//driver.setConnection(con);
		//Thread.sleep(10000);
		/*driver.toggleAirplaneMode();
		Thread.sleep(10000);*/
		if(driver.isDeviceLocked()==false)
		{
			driver.lockDevice();
		
		}
		Thread.sleep(5000);
		driver.unlockDevice();
		Thread.sleep(5000);
		
		TouchAction ta=new TouchAction(driver);
		WaitOptions wo=new WaitOptions();
		wo.withDuration(Duration.ofMillis(500));
		ta.press(ElementOption.point(540,1480)).waitAction(wo).moveTo(ElementOption.point(540, 200)).release().perform();
		Thread.sleep(5000);
		ta.press(ElementOption.point(248, 1577)).moveTo(ElementOption.point(250,1288 )).moveTo(ElementOption.point(540,1574 ))
		.moveTo(ElementOption.point(824,1288 )).moveTo(ElementOption.point(828,1575 )).release().perform();
		Thread.sleep(5000);
		
		
		
		
		

	}

}
