import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Sorting table for Player Standings list Adapted from docs.oracle.com
 * (TableSortDemo.java)
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 03/01/12
 */
public class PlayerListGUI extends JPanel {
	private boolean DEBUG = false;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;

	private Font textInputFieldFont;
	private Color textInputFieldColor;

	private JPanel playerListPanel;

	private Player[] playerArray;
	private int currentRound;

	private ImageIcon placeHolderImg = new ImageIcon(getClass().getResource(
			"images/uploadPic_small.jpg"));
	private JLabel placeHolderLbl = new JLabel(placeHolderImg);

	/******************************* CONSTRUCTOR ***********************************/
	/**
	 * Calls the player list interface
	 */
	public PlayerListGUI(Player[] playerArray, int currentRound) {
		super(new GridLayout(1, 0));
		this.playerArray = playerArray;
		this.currentRound = currentRound;

		add(createPlayerList());

	} // End of Constructor

	public JComponent createPlayerList() {
		playerListPanel = new JPanel();

		JTable table = new JTable(new MyTableModel(playerArray, currentRound));
		table.setPreferredScrollableViewportSize(new Dimension(900, 400));
		// table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(77);

		table.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		table.setForeground(Color.BLUE);
		table.setSelectionForeground(Color.RED);
		table.setOpaque(false);
		// table.setBackground(new Color(0,0,0,64));
		table.setSelectionBackground(new Color(0, 0, 64, 0));

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		playerListPanel.add(scrollPane);

		return playerListPanel;
	}

	class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "User ID", "First Name", "Last Name",
				"Total Score", "Contestant Pick" };
		private Player[] playersArray;
		private Object[][] data;

		public MyTableModel(Player[] players, int currentRound) {
			super();
			this.playersArray = players;
			if (playersArray == null) {
				data = new Object[0][5];
			} else {
				data = new Object[playersArray.length][6];
				for (int i = 0; i < playersArray.length; i++) {
					data[i][0] = playersArray[i].getID();
					data[i][1] = playersArray[i].getFirst();
					data[i][2] = playersArray[i].getLast();
					data[i][3] = playersArray[i].getScore();
					try {
						if (!playersArray[i].getWeekPick(currentRound)
								.getContestant().getPicture().equals("null")) {
							data[i][4] = playersArray[i]
									.getWeekPick(currentRound).getContestant()
									.getPicture();
						} else {
							data[i][4] = "No Selection";
						}
					} catch (Exception e) { // catch the null pointer if the
						// game isn't started yet(round
						// array is null)
						data[i][4] = "No Selection";
					}
				}
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

		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col
						+ " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			data[row][col] = value;

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
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
