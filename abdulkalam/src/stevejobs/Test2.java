package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:\\www.gmail.com"); //gmail registration no
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//*[text()='Create account']")).click();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).sendKeys("raj");
		driver.findElement(By.name("lastName")).sendKeys("reddy");
		driver.findElement(By.name("Username")).sendKeys("sandy280294sandy");
		driver.findElement(By.name("Passwd")).sendKeys("san12deep");
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("san12deep");
		driver.findElement(By.id("accountDetailsNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("phoneNumberId")).sendKeys("9959117836");
		driver.findElement(By.id("gradsIdvPhoneNext")).click();
		driver.findElement(By.xpath("//*[@aria-label='Enter verification code']")).sendKeys("");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@aria-label,'Recovery email ')]")).sendKeys("manetisandeep94@gmail.com");
		driver.findElement(By.id("day")).sendKeys("28");
		Select s=new Select(driver.findElement(By.id("month")));
		s.selectByVisibleText("February");
		driver.findElement(By.xpath("//*[@aria-label='Year']")).sendKeys("1994");
		driver.findElement(By.xpath("//*[@id='gender']")).sendKeys(Keys.DOWN,"ENTER");
		driver.findElement(By.id("personalDetailsNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@jsname='NjDI7d']")).click();
		driver.findElement(By.id("termsofserviceNext")).click();//sucessfull
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@aria-label='Scroll down']")).click();
		driver.findElement(By.xpath("//*[@aria-label='Scroll down']")).click();
		driver.findElement(By.xpath("//*[@aria-label='Scroll down']")).click();
	}

}
