package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailtest2 
{
	public static void main(String[] args) throws Exception
	{
		// open ".xls" for test data reading
		File f=new File("gmailtestdata2.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);  
		int nour=rsh.getRows();     
		int nouc=rsh.getColumns(); 
				
		//open same excel for result writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);  
		
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
		
		//Data Driven with POM
		for(int i=1;i<nour;i++)
		{
			String p=rsh.getCell(0,i).getContents();
			String pc=rsh.getCell(1,i).getContents();
			//launch site
			System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.gmail.com");
			
			//Create objects to page classes
			Homepage hp=new Homepage(driver);
			Loginpage lp=new Loginpage(driver);
			Composepage cp=new Composepage(driver);
			
			//automation code
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOf(hp.uid));
			hp.filluid("manetisandeep94");       
			w.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
			hp.uidclicknext();
			w.until(ExpectedConditions.visibilityOf(lp.pwd));
			lp.fillpwd(p);       
			w.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
			lp.pwdclicknext();
			Thread.sleep(5000);
			
			//validations
			try
			{
				if(p.length()==0 && lp.pwdblankerr.isDisplayed())
				{
					Label l1=new Label(nouc,i,"Blank pwd test passed",wcf1);
					wsh.addCell(l1);
				}
				else if(pc.equalsIgnoreCase("invalid") && lp.pwdinvaliderr.isDisplayed())
				{
					Label l2=new Label(nouc,i,"Invalid pwd test passed",wcf1);
					wsh.addCell(l2);
				}
				else if(pc.equalsIgnoreCase("valid") && cp.comp.isDisplayed())
				{
					Label l3=new Label(nouc,i,"Valid pwd test passed",wcf1);
					wsh.addCell(l3);
				}
				else
				{
					String fname=sf.format(d)+".png";
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					Label l4=new Label(nouc,i,"Valid pwd test failed",wcf2);
					wsh.addCell(l4);
					
				}
			}
			catch(Exception ex)
			{
				Label l5=new Label(nouc,i,ex.getMessage(),wcf2);
				wsh.addCell(l5);
			}
			//close site
			driver.close();
					
		}
		
		//to autofit width of excel column size
		CellView cv=rsh.getColumnView(nouc);
		cv.setAutosize(true);
		wsh.setColumnView(nouc, cv);
		//save and close excel
		wwb.write();
		wwb.close();
		rwb.close();
	
	}

}
