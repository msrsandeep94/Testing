package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test22 
{

	public static void main(String[] args) throws Exception           //FILE DOWNLOADING//  
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.seleniumhq.org");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.manage().window().maximize();
		//right click on link
		WebElement e=driver.findElement(By.linkText("Download"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		//Automate Win-menu{ROBOT}
		Robot r=new Robot();
		for(int i=1;i<=4;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
		}
		//save downloading file
		StringSelection s1=new StringSelection("G:\\batch228\\file");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		//
		driver.close();
		

	}

}
