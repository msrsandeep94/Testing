package stevejobs;

import java.util.ArrayList;
import java.util.Scanner;

public class Test42_Sorting                          //sorting on Dynamic array
{
	public static void main(String[] args) 
	{
		//declare dynamic array
		ArrayList<Integer> x=new ArrayList<Integer>();
		//fill an array
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		System.out.println("fill array");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());
		}
		//sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j) > x.get(j+1))  //'>' for ascending order
				{
					int temp=x.get(j);      // swapping code
					x.set(j,x.get(j+1));
					x.set(j+1,temp);
					
				}
			}
		}
		//display array
		for(int i=0;i<n;i++)
		{
			System.out.println(x.get(i));
		}

	}

}
