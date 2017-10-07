import javax.swing.ImageIcon;


public class bankOfNumberIcons
{  
	ImageIcon [] buttonIcons=new ImageIcon[14];
	ImageIcon buttonIcon0 = new ImageIcon("0.png");
	ImageIcon buttonIcon1 = new ImageIcon("1.png");
	ImageIcon buttonIcon2 = new ImageIcon("2.png");
	ImageIcon buttonIcon4 = new ImageIcon("4.png");
	ImageIcon buttonIcon8 = new ImageIcon("8.png");
	ImageIcon buttonIcon16 = new ImageIcon("16.png");
	ImageIcon buttonIcon32 = new ImageIcon("32.png");
	ImageIcon buttonIcon64 = new ImageIcon("64.png");
	ImageIcon buttonIcon128 = new ImageIcon("128.png");
	ImageIcon buttonIcon256 = new ImageIcon("256.png");
	ImageIcon buttonIcon512 = new ImageIcon("512.png");
	ImageIcon buttonIcon1024 = new ImageIcon("1024.png");
	ImageIcon buttonIcon2048 = new ImageIcon("2048.png");
	ImageIcon buttonIcon4096 = new ImageIcon("4096.png");
	
	public bankOfNumberIcons()
	{
		buttonIcons[0]= buttonIcon0;
		buttonIcons[1]= buttonIcon1;
		buttonIcons[2]=buttonIcon2;
		buttonIcons[3]=buttonIcon4;
		buttonIcons[4]=buttonIcon8;
		buttonIcons[5]=buttonIcon16;
		buttonIcons[6]=buttonIcon32;
		buttonIcons[7]=buttonIcon64;
		buttonIcons[8]=buttonIcon128;
		buttonIcons[9]=buttonIcon256;
		buttonIcons[10]=buttonIcon512;
		buttonIcons[11]=buttonIcon1024;
		buttonIcons[12]=buttonIcon2048;
		buttonIcons[13]=buttonIcon4096;
	
	}
	
	public ImageIcon [] getAllIcons()
	{
		return this.buttonIcons;
	}
}
