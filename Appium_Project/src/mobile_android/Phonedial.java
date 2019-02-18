package mobile_android;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Phonedial 
{
	public static void main(String[] args) throws Exception
	{
		// get mobile number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a mobile number");
		String mbno=sc.nextLine();
		//start appium server and form URL for it
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		//maintain details base for app & ARD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "1d52d6859804");
		dc.setCapability("platformNam", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("noReset", "true");
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
		for(int i=0;i<mbno.length();i++)
		{
			char d=mbno.charAt(i);
			String w="";
			switch(d)
			{
			case '0':
				w="zero";
				break;
			case '1':
				w="one";
				break;
			case '2':
				w="two";
				break;
			case '3':
				w="three";
				break;
			case '4':
				w="four";
				break;
			case '5':
				w="five";
				break;
			case '6':
				w="six";
				break;
			case '7':
				w="seven";
				break;
			case '8':
				w="eight";
				break;
			case '9':
				w="nine";
				break;
			}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc='"+w+"']")));
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+w+"']")).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Dial using SIM1']")));
		driver.findElement(By.xpath("//*[@content-desc='Dial using SIM1']")).click();
		Thread.sleep(10000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='00:15']")));
		
		try
		{
			if(driver.findElement(By.xpath("//*[@content-desc='End']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@content-desc='End']")).click();
			}
		
		}
		catch(Exception ey)
		{
			
		}
		//close app
		driver.closeApp();
	}	
	catch(Exception ez)
	{
		System.out.println(ez.getMessage());	
	}	
	//stop appium server
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	

	}

}
