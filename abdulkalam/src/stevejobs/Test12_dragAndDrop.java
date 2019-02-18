package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
 
public class Test12_dragAndDrop                //drag and drop 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://jqueryui.com/droppable"); 
		Thread.sleep(5000);	
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(e1,e2).build().perform();
		Thread.sleep(5000);
		driver.close();

	}

}
