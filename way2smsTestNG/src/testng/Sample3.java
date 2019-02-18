package testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Sample3       //parameterization using @Parameters annotation(data driven)
{
	public ChromeDriver driver;
	public WebDriverWait w;
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	}
	@Test
	@Parameters({"mbno","mbnoc","pwd","pwdc"})
	public void dologin(String x,String y,String z,String w) throws Exception
	{
		driver.findElement(By.name("mobileNo")).sendKeys(x);
		driver.findElement(By.name("password")).sendKeys(z);
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		Thread.sleep(5000);
		//validations
		try
		{
			if(x.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				Reporter.log("Blank mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(x.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				Reporter.log("Wrong sized mobile number test passed");
				Assert.assertTrue(true);
		
			}
			else if(z.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
			{
				Reporter.log("Blank password test passed");
				Assert.assertTrue(true);
				
			}
			else if(y.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
			{
				Reporter.log("Invalid mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
			{
				Reporter.log("Invalid password test passed");
				Assert.assertTrue(true);
			}
			else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			{
				Reporter.log("valid Login test passed");
				Assert.assertTrue(true);
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				String ssname=sf.format(d)+".png";
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(ssname);
				FileHandler.copy(src, dest);
				Reporter.log("Login test failed");
				String sspath="G:\\batch228\\way2smsTestNG\\"+ssname;
				String code="<img src=\"file:///"+sspath+"\" alt=\"\"/>";      //html file
				Reporter.log(code);
				Assert.assertTrue(false);
			}
	
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage());
			Assert.assertTrue(false);
		}
		
	}
  @AfterMethod
  public void closesite()
  {
	  driver.quit();
  }

}
