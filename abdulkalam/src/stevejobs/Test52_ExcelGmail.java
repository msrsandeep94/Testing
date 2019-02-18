package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Test52_ExcelGmail                                      //no
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=null;
		// open ".xls" for test data reading
		File f=new File("G:\\batch228\\abdulkalam\\gmaillogindata.xls");
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
		String colname="Results on"+sf.format(d);
		Label l=new Label(nouc,0,colname);           
		wsh.addCell(l);
		//data driven testing
		for(int i=1;i<nour;i++)             
		{
			try
			{
				
			String u=rsh.getCell(0,i).getContents();
			String uc=rsh.getCell(1,i).getContents();
			String p=rsh.getCell(2,i).getContents();
			String pc=rsh.getCell(3,i).getContents();
			
			//launch way2sms site
			System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.gmail.com");
			driver.manage().window().maximize();
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
			//do login 
			driver.findElement(By.name("identifier")).sendKeys(u);
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(5000);
			if(uc.equalsIgnoreCase("valid"))
			{
				driver.findElement(By.name("password")).sendKeys(u);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				
			}
			//validations
			if(u.length()==0)
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter an email or phone number']")));
				Label l1=new Label(nouc,i,"blank userid test passed");
				l1.setCellFormat(wcf1);
				wsh.addCell(l1);
				
			}
			else if(uc.equalsIgnoreCase("invalid"))
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@aria-live='assertive'])[1]")));
				Label l2=new Label(nouc,i,"invalid userid test passed");
				l2.setCellFormat(wcf1);
				wsh.addCell(l2);
			}
			else if(uc.equalsIgnoreCase("valid") && p.length()==0)
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Wrong password. Try again or click Forgot password to reset it.']")));
				Label l3=new Label(nouc,i,"Blank password test passed");
				l3.setCellFormat(wcf1);
				wsh.addCell(l3);
			}
			else if(uc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("invalid"))
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Wrong password. Try again')]")));
				Label l4=new Label(nouc,i,"invalid password test passed");
				l4.setCellFormat(wcf1);
				wsh.addCell(l4);
			}
			else if(uc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("valid"))
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='bBe']")));
				Label l5=new Label(nouc,i,"valid userid test passed");
				l5.setCellFormat(wcf1);
				wsh.addCell(l5);
			}
			
			else
			{
				Label l6=new Label(nouc,i,"valid userid test failed");
				l6.setCellFormat(wcf2);
				wsh.addCell(l6);
			}
			driver.close();
			}
			catch(Exception ex)
			{
				//driver.close();
				Label l8=new Label(nouc,i,ex.getMessage(),wcf2);
				wsh.addCell(l8);
			}
		}
		CellView cv=rsh.getColumnView(nouc);
		cv.setAutosize(true);
		wsh.setColumnView(nouc, cv);
		wwb.write();
		wwb.close();
		rwb.close();
	}

}
