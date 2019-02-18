package stevejobs;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test13_VA_Freetts 
{

	public static void main(String[] args)        //voice automation Freetts
	{
	Scanner sc=new Scanner(System.in);  
	System.out.println("Enter your text");
	String x=sc.nextLine();
	//convert into voice
	VoiceManager vm=VoiceManager.getInstance();
	Voice v=vm.getVoice("kevin");
	v.allocate();
	v.speak(x);
	v.deallocate();

	}

}
