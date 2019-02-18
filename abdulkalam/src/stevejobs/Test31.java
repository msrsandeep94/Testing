package stevejobs;

import java.util.Scanner;

public class Test31                        // switch case for string values
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter credit card type)");
		String x=sc.nextLine();
		switch(x)
		{
		case "visa":
			System.out.println("valid card");
			break;
		case "master":
			System.out.println("valid card");
			break;	
		case "rupay":
			System.out.println("valid card");
			break;
		default:
			System.out.println("invalid card");
			break;	
		}

	}

}
