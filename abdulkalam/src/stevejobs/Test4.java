package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4              //facebook registration  yes
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:\\www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("raj");
		driver.findElement(By.name("lastname")).sendKeys("reddy");
		driver.findElement(By.name("reg_email__")).sendKeys("manetisandeep94@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("manetisandeep94@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("san12deep");
		driver.findElement(By.name("birthday_day")).sendKeys("28");
		driver.findElement(By.name("birthday_month")).sendKeys("Feb");
		driver.findElement(By.name("birthday_year")).sendKeys("1994");
		driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
