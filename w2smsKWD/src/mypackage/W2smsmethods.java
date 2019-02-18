package mypackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W2smsmethods 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String launch(String e,String d,String c) throws Exception
	{
		if(e.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(e.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:\\batch228\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if(e.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","G:\\batch228\\iedriverserver.exe" );
			driver=new InternetExplorerDriver();
		}
		else if(e.equalsIgnoreCase("opera"))
		{
			OperaOptions oo=new OperaOptions();
			oo.setBinary("c://Program Files//opera//53.0.2907.68//opera.exe");
			System.setProperty("webdriver.opera.driver", "G://batch228//operadriver_win64//operadriver.exe");
			driver=new OperaDriver(oo);
		}
		else
		{
			return("unknown browser");
		}
		driver.get(d);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		return("Done");
		
	}
	public String fill(String e,String d,String c) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d);
		return("Done");
	}
	public String click(String e,String d,String c) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return("Done");
	}
	public String validatelogin(String e,String d,String c) throws Exception
	{
		Thread.sleep(10000);
		try
		{
			if(c.equalsIgnoreCase("all_valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equalsIgnoreCase("mbno_blank") && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equalsIgnoreCase("mbno_wrong_size") && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equalsIgnoreCase("mbno_invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equalsIgnoreCase("pwd_blank") && driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equalsIgnoreCase("pwd_invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
			{
				return("passed");
			}
			else
			{
				String temp=this.screenshot();
				return("Test failed & goto "+temp);
			}
			
		}
		catch(Exception ex)
		{
			String temp=this.screenshot();
			return("Test interrupted & goto "+temp);
		}
	}
		
	public String closesite(String e,String d,String c) throws Exception
	{
		driver.close();
		return("Done");
	}
	public String screenshot() throws Exception
	{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String ssname=sf.format(d)+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname);
		FileHandler.copy(src, dest);
		return(ssname);
	}
	
}
	


