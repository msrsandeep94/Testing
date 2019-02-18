package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage
{
	@FindBy(xpath="//*[text()='Compose']")
	public WebElement comp;
	
	public Composepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	

}
