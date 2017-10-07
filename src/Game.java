import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout; 
import javax.swing.JButton;
import javax.swing.JFrame;



public class Game extends JFrame  implements  KeyListener, ActionListener {
	private Board board;
	private int score;
	JButton Score;
	JButton newGameButton;
	JButton changeIcons;
	JButton showTable;
	JButton   exit;
	
	public Game(){
	   super("2048");
	   this.setSize(780,720); 
	   this.setUndecorated(true);
	   Dimension d = this.getToolkit().getScreenSize();
	    this.setLocation(d.width/2-375, d.height/2-380);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   Path2D p = new Path2D.Double();
	    p.append(new RoundRectangle2D.Double(0,0, 
	          getWidth(), getHeight(), 1000, 1000), false);
	    setShape(p);
	   
	   JLabel background = new JLabel(new ImageIcon("pokeball.jpg"));
	   this.setContentPane(background);
	   getContentPane().setLayout(new GridBagLayout()); //  GridBagLayout
	   GridBagConstraints c = new GridBagConstraints();

	   newGameButton = new JButton("New Game");
	   changeIcons = new JButton("Change Images");
	   showTable=new JButton("show Best Scores");
	   Score = new JButton("SCORE : "+this.score);
	   exit= new JButton("Exit");
	   Score.setFocusable(false);
	   Score.setRolloverEnabled(false);
	   changeIcons.setFocusable(false);
	   showTable.setFocusable(false);
	   exit.setFocusable(false);
	   board = new Board();
	   score=board.getScore();

	   c.weighty=BOTTOM_ALIGNMENT;
	   
	   c.gridx = 0;
	   c.gridy = 0;
	   add(exit,c);
	   
	   c.anchor=GridBagConstraints.CENTER; 
	   c.gridx = 0;
	   c.gridy = 1;
	   add(Score,c);
	   Score.setBackground(Color.white);
	   
	   c.anchor=GridBagConstraints.BELOW_BASELINE_LEADING; 
	   add(newGameButton,c);
	   
	   c.anchor=GridBagConstraints.ABOVE_BASELINE_TRAILING; 
	   add(showTable,c);
	   
	   c.anchor=GridBagConstraints.CENTER;
	   c.gridx=0;
	   c.gridy=3;
	   add(changeIcons,c);
  
	   c.fill=GridBagConstraints.BOTH;
	
	   c.gridx = 0;
	   c.gridy = 2;
	   add(board,c);
	   
	   exit.addActionListener(this);
	   newGameButton.addActionListener(this);
	   changeIcons.addActionListener(this);
	   showTable.addActionListener(this);
	   newGameButton.addKeyListener(this);  
	   this.setVisible(true);
	   this.setBackground(Color.orange);
	   }
	

	public void keyPressed(KeyEvent e){
		   board.keyPressed(e);
		   score=board.getScore();
		   Score.setText("SCORE : "+this.score);
       }

	
	public void actionPerformed(ActionEvent e)
	{
		 Object source = e.getSource();
		if(source== newGameButton)
		{
			
	      board.actionPerformedNewGame();
	      score=board.getScore();
	      Score.setText("SCORE : "+this.score);
		}
		
		if(source== changeIcons)
		{
			board.actionPerformedchangeIcons();
			try{
				   board.getSound().playPokemonSound();
			   }
			   catch(Exception t){}
		}
		
		if(source == showTable)
		{
			BestScores bestScores = new BestScores();
			BestScores.createAndShowGUI();
		}
		
		if(source== exit)
			 System.exit(0);
		
	}
	
	
	public void keyReleased(KeyEvent arg0) {	
	}
	public void keyTyped(KeyEvent arg0) {	
	}

	   public static void main(String args[]){
	         Game game = new Game();
	        
	   }
	   
	}

