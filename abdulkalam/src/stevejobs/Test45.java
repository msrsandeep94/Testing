package stevejobs;

import java.util.HashMap;
import java.util.Map;

public class Test45           //hashmap 
{

	public static void main(String[] args) 
	{
		//create hashmap
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		//insert data as pairs into hashmap
		hm.put(101, "sachin");
		hm.put(102, "kohli");
		//change value depends on key
		hm.put(102,"sandeep");
		//change key
		hm.put(103, hm.remove(102));
		//get data from hashmap
		for(Map.Entry e : hm.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		
		
		
		
		
		
		
		
	
		

	}

}
