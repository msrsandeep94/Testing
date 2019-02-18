package stevejobs;

public class Test24_PrimeNumbers 
{
	public static void main(String[] args) //prime number program
	{
		int i,j;
		for(i=1;i<=100;i++)
		{
			for(j=2;j<=i;j++)
			{
				if(i==j)
				{
					System.out.print(i+" ");      //
				}
				else if(i%j==0)
				{
					break;
				}
			}
		}

	}

}
