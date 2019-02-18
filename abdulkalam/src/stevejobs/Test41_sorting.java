package stevejobs;
import java.util.Scanner;

public class Test41_sorting        //sorting on Static array
{
	public static void main(String[] args) 
	{
		//declare static array
		int[] x=new int[5];
		//fill an array with data
		Scanner sc=new Scanner(System.in);
		System.out.println("fill array");
		for(int i=0;i<5;i++)
		{
			x[i]=sc.nextInt();
		}
		//sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j] > x[j+1])           //'>' for ascending order
				{
					int temp=x[j];        // swapping code
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		//display array
		for(int i=0;i<5;i++)
		{
			System.out.println(x[i]);
		}

	}

}
