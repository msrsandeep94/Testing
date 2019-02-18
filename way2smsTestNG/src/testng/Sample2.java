package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample2 
{
	@Test(priority=3)
	  public void method1() 
	  {
		  System.out.println("in testcase1 in samlple2");
	  }
	  @Test(priority=4)
	  public void method2() 
	  {
		  System.out.println("in testcase2 in samlple2");
	  }
	  @BeforeMethod
	  public void beforemethod() 
	  {
		  System.out.println("in beforemethod in samlple2");
	  }
	  @AfterMethod
	  public void aftermethod() 
	  {
		  System.out.println("in aftermethod in samlple2");
	  }
	  @BeforeClass
	  public void beforeclass() 
	  {
		  System.out.println("in beforeclass in samlple2");
	  }
	  @AfterClass
	  public void afterclass() 
	  {
		  System.out.println("in afterclass in samlple2");
	  }
}
