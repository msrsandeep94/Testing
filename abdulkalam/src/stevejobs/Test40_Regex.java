package stevejobs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test40_Regex
{
	public static void main(String[] args) 
	{
		String x="manETI28 S@ndeEp02 reddy 1994";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
