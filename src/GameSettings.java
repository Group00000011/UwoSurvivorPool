/**
 * GameSettings -- Dialog Box to set up and start a new game 
 * The Administrator can add & change the values until the game starts
 * TextFields takes in the number of contestants, and the amount wagered
 * TextArea displays the number of players entered in the pool
 * When the game starts, TextFields will convert to TextAreas that display settings panel TODO
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/01/12
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameSettings extends JPanel implements ActionListener {
	//Attributes
	private final int COLUMNS = 10; // the size of the text fields/area
	// The Buttons
	private JButton resetGameBtn, startGameBtn, saveSettingBtn;

	// Labels to ID fields
	private JLabel contLabel, playLabel, wagerLabel;

	// Strings for labels
	private String contString = "Number of Contestants: ";
	private String playString = "Number of Players: ";
	private String wagerString = "Amount Wagered: " ;
	
	// Fields for data entry
	private JTextField contField, wagerField;
	
	// Area that shows the number of players currently on record 
	private JTextArea playArea;
	
	// Stores the number of contestants and total number of rounds
	private int numConts;
	private int numRounds;
	
	/**
	 * Sets up the game setting panel as a custom JOptionPane Dialog
	 * Administator can enter numContestants, 
	 */
	public GameSettings() {
        super(new BorderLayout());
        
        // Create Labels
        contLabel = new JLabel(contString);
        playLabel = new JLabel(playString);
        wagerLabel = new JLabel(wagerString);
        
        // Create the text fields/areas & set them up
        contField = new JTextField();
        contField.setColumns(COLUMNS);
        wagerField = new JTextField();
        wagerField.setColumns(COLUMNS);
        
        playArea = new JTextArea();
//        playArea.setText(getNumPlayers())  ************ TODO ***************
        playArea.setEditable(false);
        playArea.setColumns(COLUMNS);
        
        // Tell accessibility tools about label/textfield & area pairs
        contLabel.setLabelFor(contField);
        playLabel.setLabelFor(playArea);
        wagerLabel.setLabelFor(wagerField);
        
        // Layout the labels in a panel
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(contLabel);
        labelPane.add(playLabel);
        labelPane.add(wagerLabel);
        
        // Layout the text fields/area in a panel
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(contField);
        fieldPane.add(playArea);
        fieldPane.add(wagerField);
        
        // Create the buttons
        resetGameBtn = new JButton("Reset Game");
        resetGameBtn.addActionListener(this);
        resetGameBtn.setActionCommand("reset");
        
        startGameBtn = new JButton ("Start Game");
        startGameBtn.addActionListener(this);
        startGameBtn.setActionCommand("start");
        
        saveSettingBtn = new JButton("Save Settings");
        saveSettingBtn.addActionListener(this);
        saveSettingBtn.setActionCommand("save");
        
        // Layout the buttons in a panel
        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPane.add(resetGameBtn);
        buttonPane.add(startGameBtn);
        buttonPane.add(saveSettingBtn);
        
        // Put the panels together, labels on the left, text fields/area on the right, buttons on the bottom
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
        add(buttonPane, BorderLayout.PAGE_END);        
	} // End of constructor
	
	public void actionPerformed(ActionEvent e) {
		/**  Reset Game button handler  **/
		if(e.getActionCommand().equals("reset")) {
			//TODO
		}
		/**	 Start Game Button Handler  
		 *  When the game starts, TextFields will convert to TextAreas that display settings panel TODO
		 **/
		if(e.getActionCommand().equals("start")) {
			Object[] options = {"OK, Start Game", "No, not yet"};
			
			// Before the game starts, a dialog box will appear to confirm settings
			JOptionPane.showOptionDialog(this, "Are you sure you are ready to start the game?\n"
												+ "You cannot add/delete players or contestants once the game has started.", "Start Game", 
												JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null,			// Does not use a custom icon
												options,		// the titles of the buttons
												options[0]);	// default button title
			
			// *********** TODO Disable player/contestant add/modify buttons
		}		
		/**  Saves the inputted settings before game starts Button Handler   **/
		if(e.getActionCommand().equals("save")) {
			if (Integer.parseInt(contField.getText()) < 6 || Integer.parseInt(contField.getText()) > 15){
				contField.setText(""); // resets the field if the number of contestants is outside the range
				JOptionPane.showMessageDialog(this, "Number of Contestants must be between 6 and 15"); // notifies the user of this requirement
				
				}
			else{
				numConts = Integer.parseInt(contField.getText());
				numRounds = numConts - 2;
				JOptionPane.showMessageDialog(this, "The total number of rounds will be: " + numRounds);
			}
		}		
	}
	/**
	 * Create GUI & Show it. 
	 */
	public void gameSettingsWindow() {
		JFrame frame = new JFrame("Game Settings");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(new GameSettings());
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * Create GUI & Show it. For thread safety, this method should be invoked from the even dispatch thread
	 * Shows the gui in this class -- used for testing
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Game Settings");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(new GameSettings());
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
