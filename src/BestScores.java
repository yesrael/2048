import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;


public class BestScores extends JPanel{
	 private boolean DEBUG = false;
    private JTable table;
	static TXTFile txtfile;
	
	
	public BestScores(){
		super (new GridLayout(1,0));
		txtfile = new TXTFile();
		String[] columnName = {"Name", "Score"};
          
		BestScore[] bs = txtfile.readFromFile();
		Object[][] dataToShow=new String[bs.length][2];
		for(int i=0 ;i< bs.length ; i++){
			String name = bs[i].getName();
			String score=new String(Integer.toString(bs[i].getData()));
				dataToShow[i][0]=name;
				dataToShow[i][1]=score;
		}
	    table = new JTable (dataToShow,columnName)
	    {
	    public boolean isCellEditable(int data,int col)
	       {
	    	   return false;
	       }
	       
	       public Component prepareRenderer(TableCellRenderer r, int data,int columns)
	       {
	    	Component c = super.prepareRenderer(r, data, columns);  
	    	 if (data%2==0)
	    		 c.setBackground(Color.WHITE);
	    	 else
	    		 c.setBackground(Color.LIGHT_GRAY);
	    	 return c;
	       }
	    };
	    table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

	    
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
	
	 
 
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    } 
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("YOUR BEST SCORES :");
      
 
        //Create and set up the content pane.
        BestScores newContentPane = new BestScores();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    
    
}
