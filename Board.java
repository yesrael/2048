

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.awt.*;
import java.awt.*;

	public class Board extends JPanel implements  KeyListener
	{
		private BL arr;
		private Sound sound;
		private int [][]array;
		private JButton [][]buttons;
		private int Score;
		private int winingCombine;
		private ImageIcon [] buttonIcons;
		private bankOfNumberIcons NumbersIcons;
		private bankOfPokemonIcons PokemonIcons;
		private TXTFile txtFile;
		
		public Board()
		{
			super(new GridLayout(4,4));
			array  = new int[4][4];
			buttons = new JButton[4][4];
			 arr=new BL();
			 sound=new Sound();
			arr.Initialization();
			array=arr.getGameMatrix();
			Score=arr.getScore();
			winingCombine=2048;  ////////////2048
			NumbersIcons=new bankOfNumberIcons();
			PokemonIcons=new bankOfPokemonIcons();
			buttonIcons=NumbersIcons.getAllIcons();
			txtFile=new TXTFile();
			
			for (int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++)
				{
					buttons[i][j]=new JButton();
					add(buttons[i][j]);
			    	buttons[i][j].setBackground(Color.DARK_GRAY);
			    	buttons[i][j].setFocusable(false);
			    	buttons[i][j].setRolloverEnabled(false);
					if(array[i][j]==0)
					{
						if((i+j)%2==0)
						buttons[i][j].setIcon(buttonIcons[0]);
						else
						buttons[i][j].setIcon(buttonIcons[1]);
					}
					if(array[i][j]==2)
						buttons[i][j].setIcon(buttonIcons[2]);
					if(array[i][j]==4)
						buttons[i][j].setIcon(buttonIcons[3]); 
				
				}   
		}
		
		public void actionPerformedNewGame()
		{
				  arr.newGame();
		          array=arr.getGameMatrix();
		          Score=arr.getScore();
		          buttonIcons=NumbersIcons.getAllIcons();
		          Paint();
		}
		
		public void actionPerformedchangeIcons()
		{
				if(buttonIcons==NumbersIcons.getAllIcons())
					buttonIcons=PokemonIcons.getAllIcons();
				else
					buttonIcons=NumbersIcons.getAllIcons();
				 Paint();
				
		}
		
	    public int getScore()
	    {
	    	return this.Score;
	    }
	    
	    public Sound getSound()
	    {
	    	return this.sound;
	    }
	    

		public void keyPressed(KeyEvent e)
		{
			boolean canPlay=true;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				canPlay=arr.play("2");
				try{
					   sound.playSound();
				   }
				   catch(Exception t){}
				Score=arr.getScore();
				Paint();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				canPlay=arr.play("8");
				try{
					   sound.playSound();
				   }
				   catch(Exception t){}
				Score=arr.getScore();
				Paint();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				canPlay=arr.play("6");
				try{
					   sound.playSound();
				   }
				   catch(Exception t){}
				Score=arr.getScore();
				Paint();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				canPlay=arr.play("4");
				try{
					   sound.playSound();
				   }
				   catch(Exception t){}
				Score=arr.getScore();
				Paint();
			}
			
			if(isCombineTheMax())
			{
				if(winingCombine==2048)////////////2048
				{
				int n = JOptionPane.showConfirmDialog(
	                    this, "Congratulations, you won \n would you like continue to play and try comebine 4096?",
	                    "'wining message",
	                    JOptionPane.YES_NO_OPTION);
				  if (n == JOptionPane.NO_OPTION) 
				    {
					  int m = JOptionPane.showConfirmDialog(
			                    this, "would you like to save your record?",
			                    "end game",
			                    JOptionPane.YES_NO_OPTION);
						  if (m == JOptionPane.NO_OPTION) {
							  actionPerformedNewGame();
							   winingCombine=2048; ///////////2048
				            }
						  else
						  {
							 String  s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name"));
                                 if(s!=null)  {
                                	 while(s.length() == 0 || s.contains(":"))
                					 {
                						 s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name \n without the character ':' "));
                					 }
							////Save the records in table
						       s=s+":"+this.Score;
				               txtFile.WriteToFile(s); }
							   actionPerformedNewGame();
							   winingCombine=2048;  /////////2048
						  }
		            }
				  else
				  {
					  winingCombine=4096;/////////4096
				  }
				}
				
				else if(winingCombine==4096) ////////////4096
				{
					int n = JOptionPane.showConfirmDialog(
		                    this, "Congratulations, you won would you like to save your record?",
		                    "'wining message",
		                    JOptionPane.YES_NO_OPTION);
					  if (n == JOptionPane.NO_OPTION) {
						  actionPerformedNewGame();
						   winingCombine=2048; ///////////2048
			            }
					  else
					  {
						  String  s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name"));

						  if(s!=null)  {
							  while(s.length() == 0 || s.contains(":"))
								 {
									 s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name \n without the character ':' "));
								 }
						////Save the records in table
						  s=s+":"+this.Score;
		                  txtFile.WriteToFile(s);
						  }
						  actionPerformedNewGame();
						   winingCombine=2048;  /////////2048 
					  }
				}
			}
			
			if (canPlay==false)
				{
				 
				int n = JOptionPane.showConfirmDialog(
	                    this, "the board is full-Game Over \n would you like to save your record?",
	                    "End game",
	                    JOptionPane.YES_NO_OPTION);
	            if (n == JOptionPane.YES_OPTION)
	            {
	            	
	            	String  s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name"));

	            	if(s!=null)  {
				     while(s.length() == 0 || s.contains(":"))
					 {
						 s = (String)JOptionPane.showInputDialog(this,(Object)("please enter your name \n without the character ':' "));
					 }
	                  ////Save the records in table 
	            	   s=s+":"+this.Score;
	                   txtFile.WriteToFile(s); }
	            	   actionPerformedNewGame();
					   winingCombine=2048;
	            }
	            else
	            {
	            	   actionPerformedNewGame();
					   winingCombine=2048;
	            }
				}
		
	      }
		
		public boolean isCombineTheMax()
		{
			for (int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++)
					if(array[i][j]==winingCombine)
						return true;
			
			return false;
		}
		
		public void Paint()
		{
			for (int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++)
				{
						if(array[i][j]==0)
						{
							if((i+j)%2==0)
							buttons[i][j].setIcon(buttonIcons[0]);
							else
							buttons[i][j].setIcon(buttonIcons[1]);
						}
					if(array[i][j]==2)
						buttons[i][j].setIcon(buttonIcons[2]);
					if(array[i][j]==4)
						buttons[i][j].setIcon(buttonIcons[3]);
					if(array[i][j]==8)
						buttons[i][j].setIcon(buttonIcons[4]);
					if(array[i][j]==16)
						buttons[i][j].setIcon(buttonIcons[5]);
					if(array[i][j]==32)
						buttons[i][j].setIcon(buttonIcons[6]);
					if(array[i][j]==64)
						buttons[i][j].setIcon(buttonIcons[7]);
					if(array[i][j]==128)
						buttons[i][j].setIcon(buttonIcons[8]);
					if(array[i][j]==256)
						buttons[i][j].setIcon(buttonIcons[9]);
					if(array[i][j]==512)
						buttons[i][j].setIcon(buttonIcons[10]);
					if(array[i][j]==1024)
						buttons[i][j].setIcon(buttonIcons[11]);
					if(array[i][j]==2048)
						buttons[i][j].setIcon(buttonIcons[12]);
					if(array[i][j]==4096)
						buttons[i][j].setIcon(buttonIcons[13]);
					
				}
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {	
		}
		@Override
		public void keyTyped(KeyEvent arg0) {	
		}

	}


