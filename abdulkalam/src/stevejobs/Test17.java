package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test17 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");  //Tooltip
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		Thread.sleep(5000);
		//
		WebElement e2=driver.findElement(By.xpath("(//*[@class='tooltip'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(e2).clickAndHold().build().perform();
		Thread.sleep(5000);
		WebElement e3=driver.findElement(By.xpath("(//*[@class='tooltip'])[1]/span"));
		String y=e3.getText();
		System.out.println(y);
		a.release().build().perform();
		//
		driver.close();
	

	}

}
