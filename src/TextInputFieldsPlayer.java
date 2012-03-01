/**  FORMATTERFACTORYDEMO.JAVA
 * Text Input Fields for contestants
 * Methods and fields used to add/modify/delets contestants
 * The Administrator can add & change the values until the game starts
 * @author Hazel R
 * February 26, 2012
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextInputFieldsPlayer extends JFrame implements ActionListener {
	private final int GAP = 20;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 350;
	
	//Labels of the fields
	private JLabel uniqueIDLabel, firstLabel, lastLabel;
	
	//Strings for Labels
	private static String uniqueIDString = "User ID: ";
	private static String firstString = "First Name: ";
	private static String lastString = "Last Name: ";
	
	//Fields for name entry
	private JTextField uniqueIDField, firstField, lastField;
	
	private JButton addButton, updateButton, cancelButton;
	
	private JPanel playerPanel;
	
    private Font textInputFieldFont;
    private Color textInputFieldColor;
	
	/**************** 	CONSTRUCTOR ***********************/
	public TextInputFieldsPlayer() {
		BorderLayout gui = new BorderLayout();	
        this.setLayout(gui);
		
		getContentPane().add(playerPanel());
		
        // Set up methods for the frame
        this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("UWOSurvivorPoolAdmin");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	} // End of Constructor
	
	/******************		METHODS		*******************/
	private JComponent playerPanel()  {
		playerPanel = new JPanel();
		// Create Labels
		uniqueIDLabel = new JLabel(uniqueIDString);
		firstLabel = new JLabel(firstString);
		lastLabel = new JLabel(lastString);
		
		// Create Textfields & set them up
		//*********  TODO  uniqueID Generator ******//
		uniqueIDField = new JTextField();
		uniqueIDField.setColumns(GAP);
		
		//*********  TODO  name fields must be 1-20 characters long  - if statement - **/
		firstField = new JTextField();
		firstField.setColumns(GAP);
		firstField.setToolTipText("The first name must be 1-20 characters long.");
		lastField = new JTextField();
		lastField.setColumns(GAP);
		lastField.setToolTipText("The last name must be 1-20 characters long.");
		
        // Tell accessibility tools about label/textfield & area pairs
		uniqueIDLabel.setLabelFor(uniqueIDField);
		firstLabel.setLabelFor(firstField);
		lastLabel.setLabelFor(lastField);
		
		//Layout labels in a panel
		JPanel labelPane = new JPanel(new GridLayout(0,1));
		labelPane.add(uniqueIDLabel);
		labelPane.add(firstLabel);
		labelPane.add(lastLabel);
		
		//Layout textfields in a panel
		JPanel fieldPane = new JPanel(new GridLayout(0,1));
		fieldPane.add(uniqueIDField);
		fieldPane.add(firstField);
		fieldPane.add(lastField);
		
		//Create Buttons
		addButton = new JButton("Add Player"); //, addIcon
		addButton.setActionCommand("add");
		addButton.addActionListener(this);
		
		updateButton = new JButton("Update Player"); //, updateIcon
		updateButton.setActionCommand("update");
		updateButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel"); 	//, quitIcon
		cancelButton.setActionCommand("x");
		cancelButton.addActionListener(this);
		
		//Layout buttons in a panel
		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPane.add(addButton);
		buttonPane.add(updateButton);
		buttonPane.add(cancelButton);
		
		//Add panels to another panel
		playerPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
		playerPanel.add(labelPane, BorderLayout.CENTER);
		playerPanel.add(fieldPane, BorderLayout.LINE_END);
		playerPanel.add(buttonPane, BorderLayout.PAGE_END);
		
		return playerPanel;
	} 
		
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("add")) {
			
		}
		if(e.getActionCommand().equals("update")) {
			
		}
		if(e.getActionCommand().equals("x")) {
			System.exit(-1);
		}
	}
	/**
	 * Change the font labels for this window
	 * @param font
	 * @param color
	 */
    protected JComponent setGameFont(Font font, Color color) {
    	this.textInputFieldFont = font;
    	this.textInputFieldColor = color;

    	JPanel panel = new JPanel();

    	uniqueIDLabel.setFont(font);
    	uniqueIDLabel.setForeground(color);
    	
    	firstLabel.setFont(font);
    	firstLabel.setForeground(color);
    	
    	lastLabel.setFont(font);
    	lastLabel.setForeground(color);
    	
    	return panel;
    }
    protected Font getGameFont() {
    	return textInputFieldFont;
    }
    protected Color getGameFontColor() {
    	return textInputFieldColor;
    }

	/**
	 * Create GUI & Show it. For thread safety, this method should be invoked from the even dispatch thread
	 * Invokes this table in other classes
	 */
	public void addPlayerCreatorPanel() {
		JFrame frame = new JFrame("Text Input Fields Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TextInputFieldsPlayer());
		frame.pack();
		frame.setVisible(true);
	}
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				UIManager.put("swing.boldMetal", Boolean.FALSE);
//				addPlayerCreatorPanel();
//			}
//		});
//	}

}
