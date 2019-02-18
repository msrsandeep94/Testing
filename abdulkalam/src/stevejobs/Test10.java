package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10                //get position & set position 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		Thread.sleep(5000);
		Point p=new Point(300,400);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		Thread.sleep(5000);
		Dimension d=new Dimension(300,100);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		
	}

}
