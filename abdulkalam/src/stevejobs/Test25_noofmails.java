package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test25_noofmails
{

	public static void main(String[] args) throws Exception 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//do login
		driver.findElement(By.name("identifier")).sendKeys("manetisandeep94@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("rajireddy94");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		//close notifications
		driver.findElement(By.xpath("//*[@class='bBe']")).click();
		//get expected count of mails in page
		int enoam=0;
		do
		{
			//get count of mails in current page
			WebElement mbt=driver.findElement(By.xpath("(//table)[4]"));
			List<WebElement>mails=mbt.findElements(By.tagName("tr"));
			int nomp=mails.size();
			//add count of mails in current page to total page
			enoam=enoam+nomp;
			//go to next page
			try
			{
				if(driver.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
					{
					break;
					}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
				Thread.sleep(10000);
			}
		}while(1<2);
		// get actual count from page
		String temp=driver.findElement(By.xpath("//*[@data-tooltip='Newer']/preceding::span[1]")).getText();
		String san=temp.replace(",","");
		int anoam=Integer.parseInt(san);
		//validation
		System.out.println(enoam+" "+anoam);
		if(enoam==anoam)
		{
			System.out.println("Gmail mail count test passed");
		}
		else
		{
			System.out.println("Gmail mail count test failed");
		}
		//do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//close site
		driver.close();	
			
	}

}
