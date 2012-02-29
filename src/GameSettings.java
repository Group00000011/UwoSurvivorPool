/**
 * The Game Settings Dialog Box
 * The Administrator can add & change the values until the game starts
 * @author Hazel R
 * February 26, 2012
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameSettings extends JPanel implements ActionListener {
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
		if(e.getActionCommand().equals("reset")) {
			
		}
		/**	 Before the game starts, a dialog box will appear to confirm settings	 **/
		if(e.getActionCommand().equals("start")) {
			Object[] options = {"OK, Start Game", "No, not yet"};
			JOptionPane.showOptionDialog(this, "Are you sure you are ready to start the game?\n"
												+ "You cannot add/delete players or contestants once the game has started.", "Start Game", 
												JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null,			// Does not use a custom icon
												options,		// the titles of the buttons
												options[0]);	// default button title
			
			// *********** TODO Disable player/contestant add/modify buttons
		}		
		if(e.getActionCommand().equals("save")) {
			
		}		
	}
	/**
	 * Create GUI & Show it. For thread safety, this method should be invoked from the even dispatch thread
	 */
	public void gameSettingsWindow() {
		JFrame frame = new JFrame("Game Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameSettings());
		frame.pack();
		frame.setVisible(true);
	}
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				UIManager.put("swing.boldMetal", Boolean.FALSE);
//				gameSettingsWindow();
//			}
//		});
//	}
}
