package stevejobs;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test14_VA_mbrola 
{

	public static void main(String[] args)              //voice automation mbrola 
	{
	Scanner sc=new Scanner(System.in);  
	System.out.println("Enter your text");
	String x=sc.nextLine();
	//convert into voice
	System.setProperty("mbrola.base","G:\\batch228\\mbrola");
	VoiceManager vm=VoiceManager.getInstance();
	Voice v=vm.getVoice("mbrola_us1");
	v.allocate();
	v.speak(x);
	v.deallocate();

	}

}
