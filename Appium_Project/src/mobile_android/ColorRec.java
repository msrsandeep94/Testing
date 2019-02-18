package mobile_android;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ColorRec 
{
	public static void main(String[] args) throws Exception
	{
		//Color ec=Color.RED;
		Color ec=new Color(255,0,0);
		File f=new File("G:\\batch228\\rose.jpg");
		BufferedImage bi=ImageIO.read(f);
		int w=bi.getWidth();
		int h=bi.getHeight();
		int count=0;
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{
				Color ac=new Color(bi.getRGB(i, j));
				if(ac.getRed()==ec.getRed() && ac.getGreen()==ec.getGreen() && ac.getBlue()==ec.getBlue())
				{
					count=count+1;
				}
			}
		}
		System.out.println("Total pixel's are:"+w*h);
		System.out.println("count of pixels with expected color:"+count);
		double percentage=count*100.0/(w*h);
		System.out.println(percentage);
		

	}

}
