import javax.swing.ImageIcon;

public class bankOfPokemonIcons 
{
	ImageIcon [] buttonIcons=new ImageIcon[14];
	ImageIcon buttonIcon0 = new ImageIcon("0.png");
	ImageIcon buttonIcon1 = new ImageIcon("1.png");
	ImageIcon buttonIcon2 = new ImageIcon("a.png");
	ImageIcon buttonIcon4 = new ImageIcon("b.png");
	ImageIcon buttonIcon8 = new ImageIcon("c.png");
	ImageIcon buttonIcon16 = new ImageIcon("d.png");
	ImageIcon buttonIcon32 = new ImageIcon("e.png");
	ImageIcon buttonIcon64 = new ImageIcon("f.png");
	ImageIcon buttonIcon128 = new ImageIcon("g.png");
	ImageIcon buttonIcon256 = new ImageIcon("h.png");
	ImageIcon buttonIcon512 = new ImageIcon("i.png");
	ImageIcon buttonIcon1024 = new ImageIcon("j.png");
	ImageIcon buttonIcon2048 = new ImageIcon("k.png");
	ImageIcon buttonIcon4096 = new ImageIcon("l.png");
	
	public bankOfPokemonIcons()
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
