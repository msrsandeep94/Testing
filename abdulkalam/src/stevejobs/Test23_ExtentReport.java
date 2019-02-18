package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;                       //Extent report
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test23_ExtentReport 
{

	public static void main(String[] args) throws Exception              //Extent Reports program
	{
		ExtentReports er=new ExtentReports("Google.html",false);
		ExtentTest et=er.startTest("Tittle test");
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:\\www.google.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		String x=driver.getTitle();
		//take current date & time as file name
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String y=sdf.format(d)+".png";
		//Get ScreenShot
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(y);//save screenshot
		FileHandler.copy(src,dest);
		if(x.equals("Google"))
		{
			et.log(LogStatus.PASS,"Tittle test passed"+et.addScreenCapture(y));
		}
		else
		{
			et.log(LogStatus.FAIL,"Tittle test failed"+et.addScreenCapture(y));
		}
		er.endTest(et);
		er.flush();
		driver.close();
		
		
	}

}
