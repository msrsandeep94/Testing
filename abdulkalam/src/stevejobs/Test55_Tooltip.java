package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test55_Tooltip 
{
	public static void main(String[] args) throws Exception
	{
		//  launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Get tooltip of an element
		//here tooltip is title attribute value
		WebElement e1=driver.findElement(By.linkText("SQL"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		Thread.sleep(10000);
		//Get tooltip of an element
		//here tooltip is a child element to element
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Right')][@class='tooltip']"));  //parent
		Actions a=new Actions(driver);
		a.moveToElement(e2).build().perform();
		WebElement e3=driver.findElement(By.xpath("//*[@class='tooltiptext tooltip-right']"));  //child element 
		a.clickAndHold(e3).build().perform();
		String y=e3.getText();
		System.out.println(y);
		a.release().build().perform();
		//close site
		driver.close();

	}

}
