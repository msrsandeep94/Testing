package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test58 //select item in a single select <div> tag dropdown
{
	public static void main(String[] args) throws Exception         
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//click on dropdown to get items in dropdown
		driver.findElement(By.xpath("(//*[@class='ui fluid selection dropdown'])[1]")).click();   //xpath for select frd dropdown  before open dropdown
		Thread.sleep(5000);
		//select item one after another
		List<WebElement> l=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));   
		for(int i=0;i<l.size();i++)
		{
			l.get(i).click();
			Thread.sleep(5000);
			//open dropdown for next item selection
			driver.findElement(By.xpath("(//*[contains(@class,'ui fluid selection dropdown')])[1]")).click();
			Thread.sleep(5000);
		}
		// to close dropdown
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
