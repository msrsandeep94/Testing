package mobile_android;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class Wheelpicker
{
	public static void main(String[] args) throws Exception
	{
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Expected color name");
		String ecn=sc.nextLine();
		ecn=ecn.toLowerCase();
		Color ec=null;
		switch(ecn)
		{
		case "red":
			ec=Color.RED;
			break;
		case "green":
			ec=new Color(0,128,0);
			break;
		case "blue":
			ec=Color.BLUE;
			break;
		case "black":
			ec=Color.BLACK;
			break;
		default:
			System.out.println("wrong color name");
			System.exit(0);
		}
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
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			TouchAction ta=new TouchAction(driver);
			//Vertical swipe for "Wheel picker"(bottom to top)
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
					break;
				}
				catch(Exception ex)
				{
					ta.press(ElementOption.point(400, 1600)).moveTo(ElementOption.point(400, 900)).release().perform();
				}
			}
			//open spinner
			driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
			//select item
			driver.findElement(By.xpath("//*[@text='"+ecn+"']")).click();
			//go to color area
			WebElement e=driver.findElement(By.xpath("//*[@class='android.view.ViewGroup'][@instance='2']"));
			int x=e.getLocation().getX();
			int y=e.getLocation().getY();
			int w=e.getSize().getWidth();
			int h=e.getSize().getWidth();
			//get screenshot of full screen
			File fullimg=driver.getScreenshotAs(OutputType.FILE);
			BufferedImage bfull=ImageIO.read(fullimg);
			//get screenshot of color area
			BufferedImage bele=bfull.getSubimage(x, y, w, h);
			int count=0;
			for(int i=0;i<w;i++)
			{
				for(int j=0;j<h;j++)
				{
					Color ac=new Color(bele.getRGB(i, j));
					if(ac.getRed()==ec.getRed() && ac.getGreen()==ec.getGreen() && ac.getBlue()==ec.getBlue())
					{
						count=count+1;
					}
				}
			}
			System.out.println("Total pixel's are:"+w*h);
			System.out.println("count of pixels with expected color:"+count);
			double percentage=count*100.0/(w*h);
			System.out.println(percentage);
			if(percentage>=90)
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
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
	}

}
