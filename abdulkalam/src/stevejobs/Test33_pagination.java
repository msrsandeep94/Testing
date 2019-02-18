package stevejobs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;          //enter word & validate each result page title which consists of searched word(ex;kalam)   
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test33_pagination 
{

	public static void main(String[] args) throws IOException      //pagination 
	{
		//make results file
		ExtentReports er=new ExtentReports("googleres.html",false);
		ExtentTest et=er.startTest("GoogleResultsTittle test");
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.chrome.driver","G://batch228//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//enter data to search
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);    //to clear cache
		//driver.findElement(By.name("btnK")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		//vaidations
		while(2>1)
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				//get screenshot
				Date d=new Date();
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				String fname=sf.format(d)+".png";
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(fname);
				FileHandler.copy(src, dest);
				et.log(LogStatus.FAIL,"Google title test failed"+et.addScreenCapture(fname));
				break;
			}
			//Go to next page
			try
			{
				if(driver.findElement(By.xpath("//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					
				}
				
			}
			catch(Exception ex)
			{
				et.log(LogStatus.PASS,"Google title test passed");
				break;
			}
			
		}
		//close site
		driver.close();
		//save results
		er.endTest(et);
		er.flush();
	}

}
