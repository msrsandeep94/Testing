package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		String x=driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("securable site");
		}
		else
		{
			System.out.println("unsecurable site");
		}
		driver.close();

	}

}
