package stevejobs;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Grid
{
	public static void main(String[] args) throws Exception
	{
		URL u=new URL("http://192.168.1.108:5556/wd/hub");
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		WebDriver driver=new RemoteWebDriver(u,dc);
		driver.get("http://www.flipkart.com");
		Thread.sleep(5000);
		String x=driver.getTitle();
		System.out.println(x);
		driver.close();
		//
		URL u1=new URL("http://192.168.1.108:5557/wd/hub");
		DesiredCapabilities dc1=DesiredCapabilities.chrome();
		WebDriver driver1=new RemoteWebDriver(u1,dc1);
		driver1.get("http://www.google.co.in");
		Thread.sleep(5000);
		String xy=driver1.getCurrentUrl();
		if(xy.contains("https"))
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
