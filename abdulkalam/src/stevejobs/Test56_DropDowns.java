package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test56_DropDowns 
{
	public static void main(String[] args)     // get count of items in a dropdown
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// get count of items in <div> tag dropdown
		
		//List<WebElement> l=driver.findElements(By.xpath("(//*[@class='ui selection dropdown'])[1]/div[2]/div")); // xpath for gender
		
		List<WebElement> l=driver.findElements(By.xpath("(//*[@class='ui fluid selection dropdown'])[1]/div[2]/div"));  //for select frd
		System.out.println(l.size());
		//cl+ose site
		driver.close();
		
	}

}
