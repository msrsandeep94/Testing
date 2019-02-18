package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test27_if_else_if 
{

	public static void main(String[] args) throws Exception             // if-else if(way2sms)  
	{
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a mobile number");
		String mbno=sc.nextLine();
		System.out.println("enter a mobile number criteria");
		String mbnoc=sc.nextLine();
		System.out.println("enter a password");
		String pwd=sc.nextLine();
		System.out.println("enter a password criteria");
		String pwdc=sc.nextLine();
		//launch way2sms site
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		//do login
		driver.findElement(By.name("mobileNo")).sendKeys(mbno);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		Thread.sleep(5000);
		//w.until(temp->driver.executeScript("return document.readyState;").equals("complete"));
		// validation
		if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
		{
			System.out.println("blank mobile no test passed ");
		}
		else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
		{
			System.out.println("wrong sized mobile no test passed ");
		}
		else if(pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
		{
			System.out.println("blank password test passed ");
		}
		else if(mbnoc.equals("invalid") && driver.findElement(By.xpath("//*[text()='Your mobile number is not register with us.']")).isDisplayed())
		{
			System.out.println("invalid mbno  test passed ");
		}
		else if(pwdc.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())	
		{
			System.out.println("invalid password test passed ");
		}
		else if(mbnoc.equals("valid") && pwdc.equals("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
		{
			
			System.out.println("valid data test passed ");
		}
		else
		{
			Date d=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			String fname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			System.out.println("login test failed ");
		}
		//close site
		driver.close();
	
	}

}
