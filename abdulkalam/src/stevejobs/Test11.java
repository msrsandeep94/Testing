package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test11 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/"); //way2sms registration no
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@href='user-registration']")).click();
		driver.findElement(By.name("name")).sendKeys("sandeep reddy");
		driver.findElement(By.name("mobileNo")).sendKeys("9959117836");
		driver.findElement(By.name("email")).sendKeys("manetisandeep94@gmail.com");
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("dob")).sendKeys("28/02/1994");
		Select s=new Select(driver.findElement(By.name("city")));
		s.selectByVisibleText("Karimnagar");
		driver.findElement(By.name("captcha")).click();//captcha manually write
		Thread.sleep(15000);
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.xpath("//*[text()='Register Now']")).click();
		
	}

}
