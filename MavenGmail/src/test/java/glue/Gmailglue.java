package glue;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailglue 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Scenario s;
	public Properties p;
	public Homepage hp;
	public Loginpage lp;
	public Composepage cp;
	@Before
	public void method1(Scenario s) throws Exception
	{
		this.s=s;  //s object work for current scenario
		FileInputStream fi=new FileInputStream("G:\\batch228\\MavenGmail\\src\\test\\resources\\repositary\\file1.properties");
		p=new Properties();
		p.load(fi);
	}
	@Given("^launch site$")
	public void method2()
	{
		System.setProperty("webdriver.chrome.driver", p.getProperty("cdpath"));
		driver=new ChromeDriver();
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		cp=new Composepage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.uid));
		driver.manage().window().maximize();
	}
	@Then("^title will be \"(.*)\" for homepage$")
	public void method3(String x)
	{
		String t=driver.getTitle();
		if(t.equals(x))
		{
			s.write("Gmail site title test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b, "Gmail site title test failed");
		}
		
	}
	@When("^close site$")
	public void method4()
	{
		driver.close();
	}
	@When("^enter userid like \"(.*)\" value$")
	public void method5(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(hp.uid));
		hp.filluid(x);
	}
	@And("^click userid next button$")
	public void method6()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
		hp.clickuidnext();
	}
	@Then("^validate userid output for \"(.*)\" with \"(.*)\" criteria$")
	public void method7(String x,String y) throws Exception
	{
		Thread.sleep(5000);
		try
		{
			if(x.length()==0 && hp.uidblankerr.isDisplayed())
			{
				s.write("UID blank value test passed");
			}
			else if(y.equalsIgnoreCase("invalid") && hp.uidinvaliderr.isDisplayed())
			{
				s.write("UID invalid value test passed");
			}
			else if(y.equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
			{
				s.write("UID valid value test passed");
			}
			else
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b, "UID test failed");
						
			}
		} 
		catch(Exception ex)
		{
			s.write(ex.getMessage());
		}
	}
	@When("^enter password like \"(.*)\" value$")
	public void method8(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(x);
	}
	@And("^click password next button$")
	public void mathod9()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
		lp.clickpwdnext();
	}
	@Then("^validate password output for \"(.*)\" with \"(.*)\" criteria$")
	public void method10(String x,String y) throws Exception
	{
		Thread.sleep(5000);
		try
		{
			if(x.length()==0 && lp.pwdblankerr.isDisplayed())
			{
				s.write("PWD blank value test passed");
			}
			else if(y.equalsIgnoreCase("invalid") && lp.pwdinvaliderr.isDisplayed())
			{
				s.write("PWD invalid value test passed");
			}
			else if(y.equalsIgnoreCase("valid") && cp.comp.isDisplayed())
			{
				s.write("PWD valid value test passed");
			}
			else
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b, "PWD test failed");
			}
		}
		catch(Exception ex)
		{
			s.write(ex.getMessage());
		}
	}
	
}
