package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test21 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:\\www.gmail.com");                                  // FILE UPLOAD//
		WebDriverWait w=new WebDriverWait(driver,100);
		Thread.sleep(5000);
		// login
		driver.findElement(By.name("identifier")).sendKeys("manetisandeep94");
		driver.findElement(By.xpath("//*[@class='qhFLie']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("rajireddy94");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//close notifications
		driver.findElement(By.xpath("//*[@role='button'][@class='bBe']")).click();
		//compose
		driver.findElement(By.xpath("//*[@role='navigation']/preceding::*[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//*[@role='textbox']")).sendKeys("Hai \n advanced happy birthday \n bye sir.");
		//click on attachment
		driver.findElement(By.id(":pt")).click();
		Thread.sleep(10000);
		//automate file upload window
		StringSelection s1=new StringSelection("C:\\Users\\sammaiah\\Pictures\\rose.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//wait until file upload to start
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='vq']")));
		//wait until complete file upload
		w.until(ExpectedConditions.attributeContains(By.xpath("//*[@class='vq']"),"role","button"));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Send')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		//do logout after closing notifications
		driver.findElement(By.xpath("//*[@role='button'][@class='bBe']")).click();
		driver.findElement(By.xpath("//*[contains(@class,'gbii')]")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.close();	

	}

}
