package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample1 
{
  @Test(priority=1)
  public void testcase1() 
  {
	  System.out.println("in testcase1 in samlple1");
  }
  @Test(priority=2)
  public void testcase2() 
  {
	  System.out.println("in testcase2 in samlple1");
  }
  @BeforeMethod
  public void beforemethod() 
  {
	  System.out.println("in beforemethod in samlple1");
  }
  @AfterMethod
  public void aftermethod() 
  {
	  System.out.println("in aftermethod in samlple1");
  }
  @BeforeClass
  public void beforeclass() 
  {
	  System.out.println("in beforeclass in samlple1");
  }
  @AfterClass
  public void afterclass() 
  {
	  System.out.println("in afterclass in samlple1");
  }
  @BeforeTest
  public void beforetest() 
  {
	  System.out.println("in beforetest in samlple1");
  }
  @AfterTest
  public void aftertest() 
  {
	  System.out.println("in aftertest in samlple1");
  }
  @BeforeSuite
  public void beforesuite() 
  {
	  System.out.println("in beforesuite in samlple1");
  }
  @AfterSuite
  public void aftersuite() 
  {
	  System.out.println("in aftersuite in samlple1");
  }
 
}
