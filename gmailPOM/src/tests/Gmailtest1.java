package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Homepage;
import pages.Loginpage;

public class Gmailtest1 
{
	public static void main(String[] args) throws Exception
	{
		//open text file for reading
		File f=new File("gmailtestdata1.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		//open html file for results
		ExtentReports er=new ExtentReports("gmailpom.html",false);
		ExtentTest et=er.startTest("Gmail UID Test");
		
		//Data driven with POM
		String l="";
		while((l=br.readLine())!=null)
		{
			String p[]=l.split(",");
			//launch site
			System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.gmail.com");
			
			//Create objects to page classes
			Homepage hp=new Homepage(driver);
			Loginpage lp=new Loginpage(driver);
			
			//automation code
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOf(hp.uid));
			hp.filluid(p[0]);        // p[0] means userid in textfile
			w.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
			hp.uidclicknext();
			Thread.sleep(5000);
			
			//validations
			try
			{
				if(p[0].length()==0 && hp.uidblankerr.isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank uid test passed");
				}
				else if(p[1].equalsIgnoreCase("invalid") && hp.uidinvaliderr.isDisplayed())
				{
					et.log(LogStatus.PASS, "Invalid uid test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
				{
					et.log(LogStatus.PASS, "Valid uid test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL,"Gmail uid test failed"+et.addScreenCapture(fname));
				
				}
			}
			catch(Exception ex)
			{
				et.log(LogStatus.ERROR,ex.getMessage());
			}
			//close site
			driver.close();
		}
		//close text file
		br.close();
		fr.close();
		//save html results file
		er.endTest(et);
		er.flush();
	
	}

}
