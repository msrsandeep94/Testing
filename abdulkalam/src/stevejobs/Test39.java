package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test39       // finalize():garbage collection            no
{
	public void finaize()
	{
		System.out.println("testing completed");
	}

	public static void main(String[] args) throws Exception
	{
		Test39 obj=new Test39();
		obj=null;
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http:\\www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();
		//finalize() can run automatically
		System.gc();
	}

}
