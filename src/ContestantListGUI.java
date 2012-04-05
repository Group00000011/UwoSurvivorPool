/**
 * ContestantListGUI -- Sort table for Contestant list, 
 * sorts table in column choice, is editable, displays the contestant image 
 * Adapted from docs.oracle.com (TableSortDemo.java)
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * V 1.0 March 1, 2012
 */
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class ContestantListGUI extends JPanel {
	// Attributes
	private static final long serialVersionUID = 1L;

	private boolean DEBUG = false;
	private static final int WIDTH = 850;
	private static final int HEIGHT = 400;
	private int numConts = 0;
	private Contestant[] contestants;
	private Font textInputFieldFont;
	private Color textInputFieldColor;

	private JPanel contListPanel;

	private ImageIcon placeHolderImg = new ImageIcon(getClass().getResource(
			"images/uploadPic_small.jpg"));

	// private JLabel imgPlaceHolder;

	/******************************* CONSTRUCTOR ***********************************/
	/**
	 * Calls the contestant list interface
	 */
	public ContestantListGUI(Contestant[] conts, int numConts) {
		super(new GridLayout(1, 0));
		this.numConts = numConts;
		this.contestants = conts;
		add(createContList());
	}

	/**
	 * Creates the contestant list sorted table
	 * 
	 * @return contestant custom table
	 */
	public JComponent createContList() {
		contListPanel = new JPanel();
		MyTableModel contTable = new MyTableModel(contestants, numConts);
		JTable table = new JTable(contTable);

		table.setPreferredScrollableViewportSize(new Dimension(WIDTH, HEIGHT));
		// table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(77);

		table.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		table.setForeground(Color.BLUE);
		table.setSelectionForeground(Color.RED);
		// table.setOpaque(false);
		// table.setBackground(new Color(0,0,0,64));
		table.setSelectionBackground(new Color(0, 0, 0, 64)); 

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		contListPanel.add(scrollPane);

		return contListPanel;
	} // End of Constructor

	/**
	 * Creates a custom sort table of contestant information This class gets
	 * called by the main panel
	 */
	class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "User ID", "First Name", "Last Name",
				"Tribe", "Picture", "Round Eliminated", "Eliminated" };
		private Contestant[] contestants;
		private Object[][] data;

		public MyTableModel(Contestant[] conts, int numConts) {
			super();
			this.contestants = conts;
			data = new Object[numConts][7];
			for (int i = 0; i < numConts; i++) {
				data[i][0] = contestants[i].getID();
				data[i][1] = contestants[i].getFirst();
				data[i][2] = contestants[i].getLast();
				data[i][3] = contestants[i].getTribe();
				if (contestants[i].getPicture() != null
						&& !contestants[i].getPicture().equals("null")) {
					// Scale the Image to fit inside the table
					ImageIcon contPic = createImageIcon(contestants[i]
							.getPicture());
					Image img = contPic.getImage();
					Image newimg = img.getScaledInstance(100, 80,
							java.awt.Image.SCALE_SMOOTH);
					contPic = new ImageIcon(newimg);
					data[i][4] = contPic;
				} else {
					data[i][4] = placeHolderImg;
				}
				if (contestants[i].getElimRound() != null) {
					Integer roundElim = contestants[i].getElimRound()
							.getRoundNum();
					data[i][5] = roundElim.toString();
				} else {
					data[i][5] = "Not Eliminated";
				}
				data[i][6] = (contestants[i].getElimRound() != null);
			}
		}

		public ImageIcon createImageIcon(String path) {
			java.net.URL imgURL = SurvivorPoolAdminGUI.class.getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL);
			} else {
				// JOptionPane.showMessageDialog(this,
				// "The image must be in the images folder.");
				return null;
			}
		}


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

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

	}

	/**
	 * To Format the fields and labels
	 * 
	 * @param font
	 * @param color
	 * @return
	 */
	protected JComponent setGameFont(Font font, Color color) {
		this.textInputFieldFont = font;
		this.textInputFieldColor = color;

		JPanel panel = new JPanel();


		return panel;
	}

	protected Font getGameFont() {
		return textInputFieldFont;
	}

	protected Color getGameFontColor() {
		return textInputFieldColor;
	}


}// End of this Class
