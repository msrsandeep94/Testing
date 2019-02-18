package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a day");
		int ed=Integer.parseInt(sc.nextLine());
		System.out.println("Enter a month");
		String em=sc.nextLine();
		System.out.println("Enter a year");
		int ey=sc.nextInt();
		//launch site
		System.setProperty("webdriver.chrome.driver", "G:\\batch228\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://jqueryui.com/datepicker");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement e=driver.findElement(By.id("datepicker"));
		driver.executeScript("arguments[0].scrollIntoView();", e);
		e.click();
		//year
		while(true)
		{
			String temp=driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
			int ay=Integer.parseInt(temp);
			if(ey<ay)
			{
				driver.findElement(By.xpath("//*[text()='Prev']")).click();
				Thread.sleep(1000);
			}
			else if(ey>ay)
			{
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(1000);
				
			}
			else
			{
				//ey=ay
				//month(come to january)
				while(true)
				{
					String temp2=driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText();
					String am=temp2.toLowerCase();
					if(!am.equalsIgnoreCase("january"))
					{
						driver.findElement(By.xpath("//*[text()='Prev']")).click();
						Thread.sleep(1000);
					}
					else
					{
						break;
					}
				}
				//month (come to excepted month from january
				//month(come to january)
				while(true)
				{
					String temp2=driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText();
					String am=temp2.toLowerCase();
					if(!am.equalsIgnoreCase(em))
					{
						driver.findElement(By.xpath("//*[text()='Next']")).click();
						Thread.sleep(1000);
					}
					else
					{
						break;
					}
				}
				break;
			}	
		}
		//day
		driver.findElement(By.xpath("//a[text()='"+ed+"']")).click();
		Thread.sleep(10000);
		//close site
		driver.close();

	}

}
