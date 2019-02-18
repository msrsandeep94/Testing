package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test15 
{

	public static void main(String[] args) throws Exception
	{
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver(o);
		driver.get("http://www.way2sms.com/"); //way2sms login & send sms
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("mobileNo")).sendKeys("9959117836");
		driver.findElement(By.name("password")).sendKeys("sandeep94");
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		Thread.sleep(5000);
		driver.switchTo().activeElement().sendKeys("9398059816");
		driver.findElement(By.name("message")).sendKeys("hai ");
		driver.findElement(By.xpath("//*[text()='Send Sms']")).click();
		driver.switchTo().alert().dismiss();

	}

}
