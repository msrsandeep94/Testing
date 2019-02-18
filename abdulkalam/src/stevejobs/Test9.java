package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 
{

	public static void main(String[] args) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:\\www.gmail.com");
		Thread.sleep(5000);	
		driver.navigate().to("http://www.google.com");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);	
		driver.navigate().forward();
		Thread.sleep(5000);	
		driver.navigate().refresh();
		Thread.sleep(5000);	
		driver.close();
	}

}
