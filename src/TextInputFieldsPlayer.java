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

public class TextInputFieldsPlayer extends JPanel implements ActionListener {
	private final int GAP = 20;
	
	//Labels of the fields
	private JLabel uniqueIDLabel, firstLabel, lastLabel;
	
	//Strings for Labels
	private static String uniqueIDString = "User ID: ";
	private static String firstString = "First Name: ";
	private static String lastString = "Last Name: ";
	
	//Fields for name entry
	private JTextField uniqueIDField, firstField, lastField;
	
	//Buttons
	private JButton addButton, updateButton, cancelButton;
	
	public TextInputFieldsPlayer() {
		super(new BorderLayout());
		
//		//Create Textfields
//		//Create Buttons
//		//Assemble Panel
//	}
//	/**
//	 * The labelled textfields
//	 * @return a panel of textfield aligned with labels
//	 */
//	protected JComponent textFields() {
//		JPanel tf = new JPanel();
		
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
		setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
		add(buttonPane, BorderLayout.PAGE_END);
	} // End of constructor
		
	
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
	 * Create GUI & Show it. For thread safety, this method should be invoked from the even dispatch thread
	 */
	public static void textInputFieldsPlayer() {
		JFrame frame = new JFrame("Text Input Fields Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TextInputFieldsPlayer());
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				textInputFieldsPlayer();
			}
		});
	}

}
