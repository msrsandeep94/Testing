package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngTest2 
{
	public ChromeDriver driver;
	public WebDriverWait w;
	
	@Test(priority=1)
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	}
	@Test(priority=2)
	public void validatelogin()
	{
		String t=driver.getTitle();
		if(t.contains("Free SMS"))
		{
			Reporter.log("Title test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Title test failed");
			Assert.assertTrue(false);
		}
	}
	@Test(priority=3)
	public void closesite()
	{
		driver.quit();
	}

}
