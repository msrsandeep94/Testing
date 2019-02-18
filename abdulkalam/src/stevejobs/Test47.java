package stevejobs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;


public class Test47      // no
{
	public static void main(String[] args) 
	{
		ChromeDriver driver=null;
		//get  test data
		HashMap<String,String> mns=new HashMap<String,String>();
		HashMap<String,String> pwds=new HashMap<String,String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter test data size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter uids");
			String m=sc.nextLine();
			System.out.println("Enter criteria");
			String mc=sc.nextLine();
			System.out.println("Enter pwds");
			String p=sc.nextLine();
			System.out.println("Enter criteria");
			String pc=sc.nextLine();
			mns.put(m, mc);
			pwds.put(p, pc);
		}
		for(Map.Entry<String,String> e:mns.entrySet())
		{
			
		}
		

	}

}
