package stevejobs;

import java.util.Scanner;

public class Test30                   // switch case for char values      yes
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marital status(y/n)");
		String l=sc.nextLine();
		char x=l.charAt(0);          // string coverted as char
		switch(x)
		{
		case 'y':
			System.out.println("married");
			break;
		case 'n':
			System.out.println("unmarried");
			break;
		default:
			System.out.println("wrong question");
			break;
			
		}
		

	}

}
