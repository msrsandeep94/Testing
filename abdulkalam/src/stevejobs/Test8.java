package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8              //cookies
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("cookies were loaded");
		}
		else
		{
			System.out.println("cookies were not loaded");
			
		}
		driver.close();

	}

}
