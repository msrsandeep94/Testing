package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement pwdnext;

	@FindBy(xpath="//*[text()='Enter a password']")
	public WebElement pwdblankerr;

	@FindBy(xpath="//*[contains(text(),'Wrong password')]")
	public WebElement pwdinvaliderr;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	public void pwdclicknext()
	{
		pwdnext.click();
	}

}
