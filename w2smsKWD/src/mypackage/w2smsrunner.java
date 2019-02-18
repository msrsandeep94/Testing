package mypackage;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class w2smsrunner 
{
	public static void main(String[] args) throws Exception
	{
		// connect to excel file
		File f=new File("w2smskwd.xls");
		// open excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0);       // 0 for sheet1(tests)
		int nour1=rsh1.getRows();
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1);       // 1 for sheet2(steps)
		int nour2=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		
		// open same excel for result writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0);  //0 means sheet1
		WritableSheet wsh2=wwb.getSheet(1);  //1 means sheet2
		
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
		Date dt=new Date();
		String cname=sf.format(dt);
		
		// set name to result column in sheet1
		Label l1=new Label(nouc1,0,cname,wcf);
		wsh1.addCell(l1);
		// set name to result column in sheet2
		Label l2=new Label(nouc2,0,cname,wcf);
		wsh2.addCell(l2);
		// create objects to methods class
		W2smsmethods ms=new W2smsmethods();
		// collect methods info using methods class object
		Method m[]=ms.getClass().getMethods();
		// keyword driven
		try 
		{
			//calling methods one after another
			//1st row (index=0) have names of columns in sheet1
			for(int i=1;i<nour1;i++)      // from 2nd row(index=1)
			{
				int flag=0;
				// get tid and mode from sheet1
				String tid=rsh1.getCell(0, i).getContents();
				String mode=rsh1.getCell(2, i).getContents();
				if(mode.equalsIgnoreCase("yes"))
				{
					//1st row (index=0)have names of columns of sheet2
					for(int j=1;j<nour2;j++)          // from 2nd row(index=1)
					{
						String sid=rsh2.getCell(0, j).getContents();
						if(tid.equalsIgnoreCase(sid))
						{
							//take step details from sheet2
							String mn=rsh2.getCell(2, j).getContents();
							String e=rsh2.getCell(3, j).getContents();
							String d=rsh2.getCell(4, j).getContents();
							String c=rsh2.getCell(5, j).getContents();
							System.out.println(mn+" "+e+" "+d+" "+c);
							for(int k=0;k<m.length;k++)
							{
								if(m[k].getName().equals(mn))
								{
									String r=(String) m[k].invoke(ms, e,d,c);
									Label lb=new Label(nouc2,j,r,wcf1);
									wsh2.addCell(lb);
									if(r.equalsIgnoreCase("unknown browser"))
									{
										wwb.write();
										wwb.close();
										rwb.close();
										System.exit(0);   //force stop run
									}
									if(r.contains("Failed") || r.contains("failed") || r.contains("interrupted") || r.contains("Interrupted"))
									{
										flag=1;
									}
									break; //terminate from loop for k 
								}
							} 
							
						}
						else
						{
							break;  //terminate from loop if tid not equal to sid
						}
					} 
					if(flag==0)
					{
						Label l=new Label(nouc1,i,"passed",wcf1);
						wsh1.addCell(l);
					}
					else
					{
						Label l=new Label(nouc1,i,"failed",wcf2);
						wsh1.addCell(l);
						
					}
				}
		
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//to autofit width of excel column size(sheet1)
		CellView cv=rsh1.getColumnView(nouc1);
		cv.setAutosize(true);
		wsh1.setColumnView(nouc1, cv);
		
		//to autofit width of excel column size(sheet2)
		CellView cv1=rsh2.getColumnView(nouc2);
		cv.setAutosize(true);
		wsh2.setColumnView(nouc2, cv1);
		//save and close excel
		wwb.write();
		wwb.close();
		rwb.close();
		
	}

}
