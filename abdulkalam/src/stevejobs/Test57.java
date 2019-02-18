package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test57
{
	public static void main(String[] args) throws Exception     //get items of a drodown to display               
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// get items of dropdown to display
		//driver.findElement(By.xpath("(//*[@class='ui selection dropdown'])[1]")).click();   //xpath for gender dropdown before open dropdown
		driver.findElement(By.xpath("(//*[@class='ui fluid selection dropdown'])[1]")).click();   //xpath for select frd dropdown  before open dropdown
		Thread.sleep(5000);
		//xpath of items for both drop up & down dropdown
		//List<WebElement> l=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));  //xpath for gender dropdown after open dropdown
		
		List<WebElement> l=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));   //xpath for select frd dropdown  after open dropdown
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		//close site
		driver.close();

	}

}
