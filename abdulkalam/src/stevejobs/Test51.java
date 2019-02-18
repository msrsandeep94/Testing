package stevejobs;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class Test51 
{
	public static void main(String[] args) throws Exception
	{
		// open ".xls" for test data reading
		File f=new File("book1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);  //0 means sheet1
		int nour=rsh.getRows();     //count of used rows
		int nouc=rsh.getColumns();  //count of used columns
				
		//open same excel for result writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);  //0 means sheet1
				
		//Data driven testing
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);
			wsh.addCell(n);
		}
		//save excel file
		wwb.write(); //save result
		wwb.close();
		rwb.close();

	}

}
