package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test59 //to check the given <div> tag dropdown is multiselect or not
{
	public static void main(String[] args) 
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//  check for multi select dropdown
		String x=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).getAttribute("class");
		if(x.contains("multiple"))
		{
			System.out.println("Multi-select dropdown");
		}
		else
		{
			System.out.println("Single-select dropdown");
		}
		//close site
		driver.close();

	}

}
