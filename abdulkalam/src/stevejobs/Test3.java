package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3          //gmail send yes
{

	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http:\\www.gmail.com");
	Thread.sleep(5000);
	driver.findElement(By.name("identifier")).sendKeys("manetisandeep94");
	driver.findElement(By.xpath("//*[@class='qhFLie']")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("password")).sendKeys("rajireddy94");
	driver.findElement(By.id("passwordNext")).click();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@role='navigation']/preceding::*[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("to")).sendKeys("msrsandeep94@gmail.com");
	driver.findElement(By.name("subjectbox")).sendKeys("selenium");
	driver.findElement(By.xpath("//*[@role='textbox']")).sendKeys("Hai ",Keys.ENTER,"good morning");
	driver.findElement(By.xpath("(//*[@tabindex='1'])[22]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@tabindex='0']/child::span[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Sign out")).click();
	Thread.sleep(5000);
	driver.close();
	
	
	}

}
