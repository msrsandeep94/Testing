package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test44_array2        //  Gmail password  via Data driven using dynamic array
{
	public static void main(String[] args)
	{
		ChromeDriver driver=null;
		//get data
		ArrayList<String> pwds=new ArrayList<String>();
		ArrayList<String> cs=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter test data size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter pwds");
			pwds.add(sc.nextLine());
			System.out.println("Enter criteria");
			cs.add(sc.nextLine());
		}
		// create html file
		ExtentReports er=new ExtentReports("gmailddt.html",false);
		ExtentTest et=er.startTest("Gmail pwd testing");
		//data driven testing
		for(int i=0;i<noi;i++)
		{
			try
			{
				//launch site
				System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.gmail.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
				//Enter valid userid and click next
				driver.findElement(By.name("identifier")).sendKeys("manetisandeep94");
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				//Enter password click next
				driver.findElement(By.name("password")).sendKeys(pwds.get(i));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				//vaidations
				if(pwds.get(i).length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank pwd test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "invalid pwd test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "valid pwd test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);	
				}
				
			}
			catch(Exception ex)
			{
				et.log(LogStatus.ERROR, "Gmail uid test failed"+ex.getMessage());
			}
		}
		//close site
		driver.close();
		//save results
		er.endTest(et);
		er.flush();
	}

}
