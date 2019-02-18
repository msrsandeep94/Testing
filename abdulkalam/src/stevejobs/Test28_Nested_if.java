package stevejobs;

import java.io.File;                          //Nested-if (gmail) no
import java.text.SimpleDateFormat;
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

public class Test28_Nested_if
{
	public static void main(String[] args) throws Exception
	{
		//create html result file
		ExtentReports er=new ExtentReports("Googleloginresults.html",false);
		ExtentTest et=er.startTest("Gmail login testing");
		//get test data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter userid");
		String uid=sc.nextLine();
		System.out.println("enter userid criteria");
		String uidc=sc.nextLine();
		String pwd="";
		String pwdc="";
		if(uidc.equals("valid"))
		{
			System.out.println("enter passwoed");
			pwd=sc.nextLine();
			System.out.println("enter password criteria");
			pwdc=sc.nextLine();
		}
		//launch site
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		// userid testing
		driver.findElement(By.name("identifier")).sendKeys(uid);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Test28_Nested_if obj=new Test28_Nested_if();//object for current class
		if(uid.length()==0)
		{
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Enter an email')]")));
				et.log(LogStatus.PASS,"blank userid test passed");
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL,"blank userid test passed"+ex.getMessage()+et.addScreenCapture(x));
			}	
		}
		else if(uidc.equals("invalid"))
		{
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
				et.log(LogStatus.PASS,"invalid userid test passed");
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL,"invalid userid test passed"+ex.getMessage()+et.addScreenCapture(x));
			}
			
		}
		else
		{
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				et.log(LogStatus.PASS,"valid userid test passed");
			
				//password testing
				driver.findElement(By.name("password")).sendKeys(pwd);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				if(pwd.length()==0)
				{
					try
					{
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter a password']")));
						et.log(LogStatus.PASS,"blank password test passed");
					}
					catch(Exception ex)
					{
						String x=obj.screenshot(driver);
						et.log(LogStatus.FAIL,"blank password test passed"+ex.getMessage()+et.addScreenCapture(x));
					}
				}
				else if(pwdc.equals("invalid"))
				{
					try
					{
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Wrong password')]")));
						et.log(LogStatus.PASS,"invalid password test passed");
					}
					catch(Exception ex)
					{
						String x=obj.screenshot(driver);
						et.log(LogStatus.FAIL,"invalid password test passed"+ex.getMessage()+et.addScreenCapture(x));
					}
				}
				else
				{
					try
					{
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
						et.log(LogStatus.PASS,"valid password test passed");
					}
					catch(Exception ex)
					{
						String x=obj.screenshot(driver);
						et.log(LogStatus.FAIL,"invalid password test passed"+ex.getMessage()+et.addScreenCapture(x));
					}
		
				}
		    }
		catch(Exception ex)
		{
			String x=obj.screenshot(driver);
			et.log(LogStatus.FAIL,"invalid password test passed"+ex.getMessage()+et.addScreenCapture(x));
		}	
	}
	//close site
	driver.close();
	//save results
	er.endTest(et);
	er.flush();
}
public String screenshot(ChromeDriver driver) throws Exception
{
	Date d=new Date();
	SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
	String fname=sf.format(d)+".png";
	File src=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File(fname);
	FileHandler.copy(src,dest);
	System.out.println("login test failed ");
	return(fname);
	
}

}
