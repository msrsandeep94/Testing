package stevejobs;

import java.util.Scanner;

public class Test26_EvenorOdd      // given number even or odd
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number ");
		int x=sc.nextInt();
		if(x%2==0)
		{
			System.out.println("even number");
		}
		else
		{
			System.out.println("odd number");
		}
		

	}

}
