package mobile_android;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class DiffUIyoutube                 //no
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a platform computer/mobile");
		String p=sc.nextLine();
		if(p.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromeriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://www.youtube.com");
		}
		else
		{
			//start appium server and form URL for it
			Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
			URL u=new URL("http://127.0.0.1:4723/wd/hub");
			//maintain details base for app & ARD
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setCapability("deviceName", "1d52d6859804");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "7.0");
			/*dc.setCapability("appPackage", "com.vodqareactnative");
			dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");*/
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
			driver.get("http://www.youtube.com");
			driver.context("NATIVE_APP");
			String x=driver.getContext();
			System.out.println(x);
			TouchAction ta=new TouchAction(driver);
			ta.tap(ElementOption.point(870, 320)).perform();
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
			driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("f2 trailer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search YouTube']")));
			driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			//driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").index(3)").click();
			
			
			
		
			
		}

	}

}
