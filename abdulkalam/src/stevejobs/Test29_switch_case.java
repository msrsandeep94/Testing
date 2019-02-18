package stevejobs;
import java.util.Scanner;
public class Test29_switch_case                       
{
	public static void main(String[] args)             // switch case for numaric values
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter  number");
		int x=sc.nextInt();
		switch(x)
		{
		case 1:
			System.out.println("sunday");
			break;
		case 2:
			System.out.println("monday");
			break;
		case 3:
			System.out.println("thuesday");
			break;
		case 4:
			System.out.println("wednesday");
			break;
		case 5:
			System.out.println("thursday");
			break;
		case 6:
			System.out.println("friday");
			break;
		case 7:
			System.out.println("satarday");
			break;
		default:
			System.out.println("wrong day");
			break;
		}
	}
}
