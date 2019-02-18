package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngTest1
{
  @Test
  public void f() 
  {
	  System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
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
		driver.close();
  }
}
