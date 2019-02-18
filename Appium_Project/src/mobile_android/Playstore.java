package mobile_android;


import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

public class Playstore 
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
				
					Thread.sleep(5000);
					KeyEvent k=new KeyEvent(AndroidKey.HOME);
					driver.pressKey(k);
					Thread.sleep(5000);
					driver.activateApp("com.android.vending");
					Thread.sleep(10000);
					//horizontal swipe(right to left)
					TouchAction ta=new TouchAction(driver);
					while(true)
					{
						Thread.sleep(2000);
						List<MobileElement> l1=driver.findElements(By.xpath("(//android.support.v7.widget.RecyclerView[@resource-id='com.android.vending:id/cluster_content'])[2]/child::*"));
						System.out.println(l1.size());
						if(l1.get(l1.size()-1).getAttribute("className").equals("android.view.View"))
						{
							break;
						}
						else
						{
							ta.press(ElementOption.point(800, 900)).moveTo(ElementOption.point(100, 900)).release().perform();
						}
						
					}
					

	}

}
