package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test62 
{
	public static void main(String[] args)        //paytm
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.paytm.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log In/Sign Up']")));
		//click on login icon
		driver.findElement(By.xpath("//*[text()='Log In/Sign Up']")).click();
		
		// 
		driver.switchTo().frame(0);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login/Signup with mobile number and password']")));
		driver.findElement(By.xpath("//*[text()='Login/Signup with mobile number and password']")).click();
		//do login
		driver.findElement(By.name("username")).sendKeys("9959117836");
		driver.findElement(By.name("password")).sendKeys("xxxxxxxxx");
		driver.findElement(By.xpath("(//*[contains(text(),'Login Securely')])[1]")).click();
		

		
		

	}

}
