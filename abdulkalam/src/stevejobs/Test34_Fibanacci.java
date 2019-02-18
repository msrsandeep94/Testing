package stevejobs;

import java.util.Scanner;

public class Test34_Fibanacci                // Fibanacci series
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit");
		int l=sc.nextInt();
		int x=0;
		int y=1;
		do
		{
			int z=x+y;
			System.out.print(z+" ");
			x=y;
			y=z;
		}while((x+y)<l);

	}

}
