package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test16_VA_vbCableDriver 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);                  //vb cable driver 
		System.out.println("enter your text");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.chrome.driver","G:\\batch228\\Chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//click on mic icon
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spchb")));
		//send voice(freetts+mbrola+vb cable driver)
		System.setProperty("mbrola.base","G:\\batch228\\mbrola");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
			
	}

}
