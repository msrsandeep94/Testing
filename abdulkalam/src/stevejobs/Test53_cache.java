package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test53_cache 
{
	public static void main(String[] args) throws Exception
	{
		// launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Enter text into Cache element
		driver.findElement(By.name("q")).sendKeys("virat");
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		int flag=0;
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			String x=driver.findElement(By.name("q")).getAttribute("value");
			if(x.equalsIgnoreCase("virat kohli anushka"))
			{
				//a.sendKeys(Keys.ENTER);
				flag=1;
			}
		}
		if(flag==1)
		{
			System.out.println("item found in Cache");
		}
		else
		{
			System.out.println("Item not found in Cache");
			
		}
		driver.close();

	}

}
