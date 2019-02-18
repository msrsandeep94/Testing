package stevejobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class Test49 
{
	public static void main(String[] args) throws Exception
	{
		//open text file for data reading
		File f1=new File("G://batch228//abdulkalam//w2smstestdata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		//open other text file for result writing
		File f2=new File("G://batch228//abdulkalam//w2smstestresults.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//Data Driven Testing
		ChromeDriver driver=null;
		String l="";  //get 1st line from file
		while((l=br.readLine())!=null)
		{
			String[] p=l.split(",");
			
			try
			{
				ChromeOptions o=new ChromeOptions();           //to handle browser notifications
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
					bw.write("Blank mobile number test passed");
					bw.newLine();
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					bw.write("Wrong sized mobile number test passed");
					bw.newLine();
				}
				else if(p[2].length()==0 && driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
				{
					bw.write("Blank password test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
				{
					bw.write("Invalid mobile number test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					bw.write("Invalid password test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					bw.write("valid Login test passed");
					bw.newLine();
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					bw.write("Login test failed");
					bw.newLine();
				}
				//close site
				driver.close();
			
			}
			catch(Exception ex)
			{
				driver.close();
				bw.write("ERROR");
				bw.newLine();
			}
		
		}
		
		//close text files
		bw.close();
		br.close();
		fr.close();
		fw.close();
	}
		
}
