package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test18 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");  //css colour&underine
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//get details before focus
		WebElement e=driver.findElement(By.xpath("(//*[text()='Gmail'])[1]"));
		String o1=e.getCssValue("opacity");
		String td1=e.getCssValue("text-decoration");
		//focus on element
		Actions a=new Actions(driver);
		a.moveToElement(e).clickAndHold().build().perform();
		//get details after focus
		String o2=e.getCssValue("opacity");
		String td2=e.getCssValue("text-decoration");
		a.release().build().perform();
		driver.close();
		System.out.println(o1+" "+o2);
		System.out.println(td1+" "+td2);

	}

}
