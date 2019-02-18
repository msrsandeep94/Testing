package stevejobs;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test54_Cache //google cache testing with dynamic data
{
	public static void main(String[] args) throws Exception
	{
		// take inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		System.out.println("Enter expected suggestion");
		String y=sc.nextLine();
		// launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Enter text into Cache element
		driver.findElement(By.name("q")).sendKeys(x);
		Thread.sleep(5000);
		//collect items in cache
		List<WebElement> l=driver.findElements(By.xpath("//*[@role='listbox']/li"));
		Actions a=new Actions(driver);
		int flag=0;
		for(int i=1;i<l.size();i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			String v=driver.findElement(By.name("q")).getAttribute("value");
			if(v.equals(y))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				flag=1;
			}
			Thread.sleep(2000);
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
