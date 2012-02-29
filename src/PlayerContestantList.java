/**
 * Sorting table for Contestant and Player lists
 * Adapted from docs.oracle.com (TableSortDemo.java)
 * @author Hazel R
 * February 25, 2012
 */
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.Dimension;
import java.awt.GridLayout;

public class PlayerContestantList extends JPanel{
	private boolean DEBUG = false;
	
	public PlayerContestantList() {
		super(new GridLayout(1,0));
		
		JTable table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		
		//Add the scroll pane to this panel.
		add(scrollPane);
	}
	
	class MyTableModel extends AbstractTableModel {

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	
}// End of this Class
