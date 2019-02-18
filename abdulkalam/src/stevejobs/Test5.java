package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test5               //facebook login yes
{
  public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver(o);
		driver.get("http:\\www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("9985883011");
		driver.findElement(By.name("pass")).sendKeys("rajireddy94");
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
		Thread.sleep(5000);
		//search
		driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("anil kola");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys(Keys.ENTER);
		// send
		driver.switchTo().activeElement().sendKeys("ekada ra",Keys.ENTER);
		//close message tab
		//driver.findElement(By.xpath("//*[@aria-label='Close tab']")).click();
		


		
	}

}
