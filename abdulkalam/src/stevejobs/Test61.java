package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test61        // Deselect Selected items from mutli-Select <div> tag dropdown
{
	public static void main(String[] args) throws Exception
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// click on multiselect dropdown
		driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).click();
		Thread.sleep(5000);
				
		// collect all items into list
		List<WebElement> l=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));
				
		//select 1st,5th,12th items in that dropdown
		l.get(0).click();  //0 means 1st item
		Thread.sleep(5000);
		l.get(4).click();   //4 means 5th item
		Thread.sleep(5000);
		l.get(11).click();   //11 means 12th item
		
		//Deselect selected items
		List<WebElement> l2=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/a/i"));
		for(int i=0;i<l2.size();i++)
		{
			l2.get(i).click();
			Thread.sleep(5000);
		}
		//close site
		driver.close();

	}

}
