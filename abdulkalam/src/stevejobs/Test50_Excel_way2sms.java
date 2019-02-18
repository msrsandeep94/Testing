package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test50_Excel_way2sms
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=null;
		// open ".xls" for test data reading
		File f=new File("w2smstestdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);  //0 means sheet1
		int nour=rsh.getRows();     //count of used rows
		int nouc=rsh.getColumns();  //count of used columns
		
		//open same excel for result writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);  //0 means sheet1
		
		//set font style,color and cell alignment heading
		WritableFont wf=new WritableFont(WritableFont.TIMES,11,WritableFont.BOLD);
		wf.setColour(Colour.BLUE);
		WritableCellFormat wcf=new WritableCellFormat(wf);
		wcf.setAlignment(Alignment.JUSTIFY);
		wcf.setAlignment(Alignment.CENTRE);
		
		//set font style,color and cell alignment for Test PASSED
		WritableFont wf1=new WritableFont(WritableFont.TIMES,11);
		wf1.setColour(Colour.GREEN);
		WritableCellFormat wcf1=new WritableCellFormat(wf1);
		wcf1.setAlignment(Alignment.JUSTIFY);
		wcf1.setAlignment(Alignment.CENTRE);
		
		//set font style,color and cell alignment for Test FAILED
		WritableFont wf2=new WritableFont(WritableFont.TIMES,11);
		wf2.setColour(Colour.RED);
		WritableCellFormat wcf2=new WritableCellFormat(wf2);
		wcf2.setAlignment(Alignment.JUSTIFY);
		wcf2.setAlignment(Alignment.CENTRE);
		
		//take results heading as date and time format
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d=new Date();
		String colname=sf.format(d);
		Label l=new Label(nouc,0,colname,wcf);           
		wsh.addCell(l);
		
		//Data driven Testing
		for(int i=1;i<nour;i++)    //i=1 means 2nd row onwards because 1st consists names of coumns
		{
			String mbno=rsh.getCell(0,i).getContents();
			String mbnoc=rsh.getCell(1,i).getContents();
			String pwd=rsh.getCell(2,i).getContents();
			String pwdc=rsh.getCell(3,i).getContents();
			
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
				driver.findElement(By.name("mobileNo")).sendKeys(mbno);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				//validations
				if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					Label l1=new Label(nouc,i,"Blank mobile number test passed",wcf1);
					wsh.addCell(l1);
				}
				else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					Label l2=new Label(nouc,i,"Wrong sized mobile number test passed",wcf1);
					wsh.addCell(l2);
				}			
				else if(pwd.length()==0 && driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
				{
					Label l3=new Label(nouc,i,"Blank password test passed",wcf1);
					wsh.addCell(l3);
				}
				else if(mbnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
				{
					Label l4=new Label(nouc,i,"Invalid mobile number test passed",wcf1);
					wsh.addCell(l4);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					Label l5=new Label(nouc,i,"Invalid password test passed",wcf1);
					wsh.addCell(l5);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					Label l6=new Label(nouc,i,"valid Login test passed",wcf1);
					wsh.addCell(l6);
				}
				else
				{
					
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					Label l7=new Label(nouc,i,"Login test failed"+fname,wcf2);
					wsh.addCell(l7);				}
				//close site
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
				Label l8=new Label(nouc,i,ex.getMessage(),wcf2);
				wsh.addCell(l8);
			}
		
		}
		//to autofit width of excel column size
		
		CellView cv=rsh.getColumnView(nouc);
		cv.setAutosize(true);
		wsh.setColumnView(nouc, cv);
		
		//save excel file
		wwb.write(); //save result
		wwb.close();
		rwb.close();
	
	}

}
