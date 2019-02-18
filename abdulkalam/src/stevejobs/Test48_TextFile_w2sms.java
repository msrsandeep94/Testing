package stevejobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test48_TextFile_w2sms    
{
	public static void main(String[] args) throws Exception //way2sms via DDT using Text file
	{
		//open text file for data reading
		File f=new File("G://batch228//abdulkalam//w2smstestdata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		//create  html results file
		ExtentReports er=new ExtentReports("w2smsddt.html",false);
		ExtentTest et=er.startTest("way2sms login testing");
		//Data driven testing
		ChromeDriver driver=null;
		String l="";
		while((l=br.readLine())!=null)
		{
			String[] p=l.split(",");
		
			try
			{
				ChromeOptions o=new ChromeOptions();              //to handle browser notifications
				o.addArguments("--disable-notifications");
				//launch way2sms site
				System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
				driver=new ChromeDriver(o);
				driver.get("http://www.way2sms.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				//do login
				driver.findElement(By.name("mobileNo")).sendKeys(p[0]);
				driver.findElement(By.name("password")).sendKeys(p[2]);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				//validations
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank mobile number test passed");
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Wrong sized mobile number test passed");
				}
				else if(p[2].length()==0 && driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank password test passed");
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Invalid mobile number test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Invalid password test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "valid Login test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL,"Login test failed"+et.addScreenCapture(fname));
				}
				//close site
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
				et.log(LogStatus.ERROR, ex.getMessage());
			}
		}
		//close text files 
		br.close();
		fr.close();
		//save results
		er.endTest(et);
		er.flush();
	}

}
