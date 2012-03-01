/**
 * Sorting table for Contestant and Player lists
 * Adapted from docs.oracle.com (TableSortDemo.java)
 * @author Hazel R
 * February 25, 2012
 */
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class PlayerListGUI extends JPanel	{
	private boolean DEBUG = false;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 350;

    private Font textInputFieldFont;
    private Color textInputFieldColor;
    
    private JPanel playerListPanel;
	
	public PlayerListGUI() {
		super(new GridLayout(1,0));
		
		add(createPlayerList());

	}
	public JComponent createPlayerList() {
		playerListPanel = new JPanel();
		
		JTable table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500,200));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		
		//Add the scroll pane to this panel.
		playerListPanel.add(scrollPane);	
		
		return playerListPanel;
	}
	
	class MyTableModel extends AbstractTableModel {
		private String[] columnNames =  {"User ID", "First Name", "Last Name", "This Weeks Score", "Total Score", "Contestant Pick"};
		
		private Object[][] data = {  /*************** TODO Implement getters  here */
				{ "mgrabar", "Martin", "Grabarczyk", "* implement *", "* implement *", "[ Contestant Image ]" },
				{ "hrivera", "Hazel", "Rivera", "* implement *", "* implement *", "[ Contestant Image ]" },
				{ "mfreema", "Manor", "Freeman", "* implement *", "* implement *", "[ Contestant Image ]" },
				{ "dhill", "Delerinoa", "Grabarczyk", "* implement *", "* implement *", "[ Contestant Image ]" },
				{ "jwestaw", "Jeff", "Westaway", "* implement *", "* implement *", "[ Contestant Image ]" },
				{ "lcorrig", "Liam", "Corrigan", "* implement *", "* implement *", "[ Contestant Image ]" },
		};
		public int getColumnCount() {
			return columnNames.length;
		}
		public int getRowCount() {
			return data.length;
		}
		public String getColumnName(int col) {
			return columnNames[col];
		}
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		/*
		 * Default renderer/editor for this cell.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0,c).getClass();
		}
		/*
		 * This method makes the tables editable
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the cell address is constant
			if(col < 2) {
				return false;
			} else {
				return true;			
			}
		}
		 /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
 
            data[row][col] = value;
            // Normally, one should call fireTableCellUpdated() when
            // a value is changed.  However, doing so in this demo
            // causes a problem with TableSorter.  The tableChanged()
            // call on TableSorter that results from calling
            // fireTableCellUpdated() causes the indices to be regenerated
            // when they shouldn't be.  Ideally, TableSorter should be
            // given a more intelligent tableChanged() implementation,
            // and then the following line can be uncommented.
            // fireTableCellUpdated(row, col);
 
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }
 
        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
 
            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
	/**
	 * To Format the fields and labels
	 * @param font
	 * @param color
	 * @return
	 */
    protected JComponent setGameFont(Font font, Color color) {
    	this.textInputFieldFont = font;
    	this.textInputFieldColor = color;

    	JPanel panel = new JPanel();
    	
//    	id.setFont(font);
//    	id.setForeground(color);
//    	
//    	first.setFont(font);
//    	first.setForeground(color);
//    	
//    	last.setFont(font);
//    	last.setForeground(color);
//    	
    	return panel;
    }
    protected Font getGameFont() {
    	return textInputFieldFont;
    }
    protected Color getGameFontColor() {
    	return textInputFieldColor;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        PlayerListGUI newContentPane = new PlayerListGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}// End of this Class
