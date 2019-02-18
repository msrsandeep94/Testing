package testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Sample5                           //way2sms test using excel test data and results open automaticaly
{
	public ChromeDriver driver;
	public WebDriverWait w;
	@DataProvider(name="testdata")
	public Object[][] method() throws Exception
	{
		//open excel file for read mode
		File f=new File("way2smstestdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		//Rows-no.of times test has to be repeated
		//Column-no.of parameters in test data
		Object[][] data=new Object[nour-1][4];
		//1st row(index=0) in excel have column names
		//copy data from 2nd row(index=1)
		for(int i=1;i<nour;i++)
		{
			/*data[i-1][0]=rsh.getCell(0,i).getContents();
			data[i-1][1]=rsh.getCell(1,i).getContents();
			data[i-1][2]=rsh.getCell(2,i).getContents();
			data[i-1][3]=rsh.getCell(3,i).getContents();*/
			for(int j=0;j<nouc;j++)
			{
				data[i-1][j]=rsh.getCell(j,i).getContents();
			}
			
		}
		rwb.close();
		//return array
		return(data);
	}
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	}
	@Test(dataProvider="testdata")
	public void dologin(String x,String y,String z,String w) throws Exception
	{
		driver.findElement(By.name("mobileNo")).sendKeys(x);
		driver.findElement(By.name("password")).sendKeys(z);
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		Thread.sleep(5000);
		//validations
		try
		{
			if(x.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				Reporter.log("Blank mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(x.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				Reporter.log("Wrong sized mobile number test passed");
				Assert.assertTrue(true);
		
			}
			else if(z.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
			{
				Reporter.log("Blank password test passed");
				Assert.assertTrue(true);
				
			}
			else if(y.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
			{
				Reporter.log("Invalid mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
			{
				Reporter.log("Invalid password test passed");
				Assert.assertTrue(true);
			}
			else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			{
				Reporter.log("valid Login test passed");
				Assert.assertTrue(true);
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				String ssname=sf.format(d)+".png";
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(ssname);
				FileHandler.copy(src, dest);
				Reporter.log("Login test failed");
				String sspath="G:\\batch228\\way2smsTestNG\\"+ssname;
				String code="<img src=\"file:///"+sspath+"\" alt=\"\"/>";      //html file
				Reporter.log(code);
				Assert.assertTrue(false);
			}
	
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterMethod
	public void closesite()
	{
		driver.quit();
	}
	
	/*@BeforeSuite
	public void start()
	{
		System.out.println("test started");
	}*/
	
	@AfterSuite
	public void results()
	{
		driver=new ChromeDriver();
		driver.get("file://G:/batch228/way2smsTestNG/test-output/index.html");
	}
	
}
