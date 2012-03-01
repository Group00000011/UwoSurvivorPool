/**
 * Text Input Fields for contestants
 * Methods and fields used to add/modify/delets contestants
 * The Administrator can add & change the values until the game starts
 * @author Hazel R
 * February 26, 2012
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextInputFieldContestant extends JFrame implements ActionListener {
	private final int GAP = 20;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 350;
	
	//Labels of the fields
	private JLabel uniqueIDLabel, firstLabel, lastLabel, tribeLabel;
	
	//Strings for Labels
	private static String uniqueIDString = "User ID: ";
	private static String firstString = "First Name: ";
	private static String lastString = "Last Name: ";
	private static String tribeString = "Tribe Name: ";
	
	//Fields for name entry
	private JTextField uniqueIDField, firstField, lastField, tribeField;
	
	//Buttons
	private JButton addButton, updateButton, cancelButton, uploadBtn;
	
	//The record display
	private JPanel contPanel,recordPanel;
    private JLabel recordDisplay;
    private boolean updated = false;
    private ImageIcon uploadedImage;


	
    private Font textInputFieldFont;
    private Color textInputFieldColor;
	
	/***************  CONSTRUCTOR *****************/
	public TextInputFieldContestant() {
		FlowLayout layout = (new FlowLayout(FlowLayout.LEADING));
		this.setLayout(layout);
        
        JPanel leftHalf = new JPanel()
        {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize() {
                Dimension pref = getPreferredSize();
                return new Dimension(Integer.MAX_VALUE,
                                     pref.height);
            }
        };
        leftHalf.setLayout(new BoxLayout(leftHalf,BoxLayout.PAGE_AXIS));
        leftHalf.add(contInputPanel());
        
        getContentPane().add(leftHalf);
        getContentPane().add(createRecordDisplay());
		
        // Set up methods for the frame
        this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
//		this.setTitle("UWOSurvivorPoolAdmin");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	} // End of Constructor
	/***************  MEHTODS  *****************/
	/**
	 * The input panel for the contestant
	 * @return a panel of textfield aligned with labels
	 */
	protected JComponent contInputPanel() {
		contPanel = new JPanel();
		
		// Create Labels
		uniqueIDLabel = new JLabel(uniqueIDString);
		firstLabel = new JLabel(firstString);
		lastLabel = new JLabel(lastString);
		tribeLabel = new JLabel(tribeString);
		
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
		tribeField = new JTextField();
		tribeField.setColumns(GAP);
		tribeField.setToolTipText("The tribe name of the contestant");
		
        // Tell accessibility tools about label/textfield & area pairs
		uniqueIDLabel.setLabelFor(uniqueIDField);
		firstLabel.setLabelFor(firstField);
		lastLabel.setLabelFor(lastField);
		tribeLabel.setLabelFor(tribeField);
		
		//Layout labels in a panel
		JPanel labelPane = new JPanel(new GridLayout(0,1));
		labelPane.add(uniqueIDLabel);
		labelPane.add(firstLabel);
		labelPane.add(lastLabel);
		labelPane.add(tribeLabel);
		
		//Layout textfields in a panel
		JPanel fieldPane = new JPanel(new GridLayout(0,1));
		fieldPane.add(uniqueIDField);
		fieldPane.add(firstField);
		fieldPane.add(lastField);
		fieldPane.add(tribeField);
		
		//Create Buttons
		addButton = new JButton("Add Contestant"); //, addIcon
		addButton.setActionCommand("add");
		addButton.addActionListener(this);
		
		updateButton = new JButton("Update Contestant"); //, updateIcon
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
		/* Layout pseudoCode:
		 * vertical layout = sequential group { parallel group (BASELINE) { IDL, IDF}, parallel group (BASELINE) {FF, FL}, 
		 * parallel group (BASELINE) {LF, LL}, parallel group (BASELINE) {TF, TL}, updateButton, parallel group (BASELINE) {Y, N} 
		 */
		GroupLayout layout = new GroupLayout(contPanel);
		contPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
			      .addComponent(uniqueIDLabel)
				  .addComponent(firstLabel)
				  .addComponent(lastField)
				  .addComponent(tribeField)		           
				  .addComponent(uploadButton())
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(addButton)
					           .addComponent(updateButton)
					           .addComponent(cancelButton))	
//			      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//			           .addComponent(uniqueIDLabel)
//			           .addComponent(uniqueIDField))
//			      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//			           .addComponent(firstLabel)
//			           .addComponent(firstField))
//			      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//			           .addComponent(lastLabel)
//			           .addComponent(lastField))
//			      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//			           .addComponent(tribeLabel)
//			           .addComponent(tribeField))			           
//			      .addComponent(uploadButton())
//			      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//				           .addComponent(addButton)
//				           .addComponent(updateButton)
//				           .addComponent(cancelButton))	
			);
		 
//		contPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
//		contPanel.add(labelPane, BorderLayout.CENTER);
//		contPanel.add(fieldPane, BorderLayout.LINE_END);
//		contPanel.add(buttonPane, BorderLayout.PAGE_END);
		
		return contPanel;
	
	} // End contInputPanel
    /**
     * This button allows the user to upload a pic from file and it will fit the image into a special frame
     * depending on the theme.
     * @return upload button
     */
    protected JComponent uploadButton() {
    	JPanel p = new JPanel();
    	
    	uploadedImage = new ImageIcon(getClass().getResource("images/uploadPicFrame_Goldblank.jpg"), "No Contestant Image has been loaded yet.");
    	
    	uploadBtn = new JButton("Upload a Picture", uploadedImage);
    	uploadBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
    	uploadBtn.setHorizontalTextPosition(AbstractButton.CENTER);
    	uploadBtn.setActionCommand("upload");
    	uploadBtn.addActionListener(this);
    	
    	p.setOpaque(false);
    	p.add(uploadBtn);
    	return p;
    }
    /**
     * Create Record Display - When a record has been added or updated
     * a panel on the right will display the entire record
     */
    protected JComponent createRecordDisplay() {
    	recordPanel = new JPanel(new BorderLayout());
    	recordDisplay = new JLabel();
    	recordDisplay.setHorizontalAlignment(JLabel.CENTER);
    	
    	updateDisplays();
    	
    	//Lay out the panel
//    	recordPanel.setBorder(BorderFactory.createEmptyBorder(
//    								GAP/2, 	//top
//    								0,    	//left
//    								GAP/2,	//bottom
//    								0));	//right
    	recordPanel.setOpaque(false);
    	recordPanel.setBackground(Color.YELLOW);
    	recordPanel.setForeground(Color.WHITE);
    	recordPanel.add(recordDisplay,BorderLayout.NORTH);
    	recordPanel.setPreferredSize(new Dimension(400,268));
    	
    	////////////////// TO DO: Implement adding image box to record display for Contestant panel only
    	/// Either by creating a seperate method and adding as an if statement in this panel
    	/// IE if TextInputField contains uploadedImage()...Add the formatted image to this panel
    	/// Or create a second method specific for contestants/players
    	//////cuz players dont have pics or tribes & contestants dont have unique ids
    	return recordPanel;    	    	
    }
    /**
     * Updates a formatted display of the record added or edited
     */
    protected void updateDisplays() {
    	recordDisplay.setText(formatField());
//    	if(updated) {
//    		recordDisplay.setFont(regularFont);
//    	} else {
//    		recordDisplay.setFont(italicFont);
//    	}
    }
    /**
     * Formats the text fields to the within project specifications
     */
     protected String formatField() {
     	if(!updated) return "No record set.";
     	
     	String firstName = firstField.getText();
     	String lastName = lastField.getText();
     	String uniqueID = uniqueIDField.getText();
     	String tribe = tribeField.getText();
     	String empty = "";
     	
     	if((firstName == null) || empty.equals(firstName)) {
     		firstName = "<em>(no first name specified)</em>";
     		//+ must be 1-20 letters
     	}
     	if((lastName == null) || empty.equals(lastName)) {
     		lastName = "<em>(no last name specified)</em>";
     		//+ must be 1-20 letters
     	}
     	if((uniqueID == null) || empty.equals(uniqueID)) {
     		uniqueID = "";

     	}
     	if((firstName == null) || empty.equals(firstName)) {
     		firstName = "<em>(no first name specified)</em>";
     	}
     	
     	StringBuffer sb = new StringBuffer();
     	sb.append("<html><p align=center>");
     	sb.append(firstName);
     	sb.append(" ");
     	sb.append(lastName);
     	sb.append(uniqueID);
     	sb.append("<br>");
     	sb.append(tribe);
     	sb.append("</p></html>");
     	
     	return sb.toString();    	
     }	
	/**
	 * Action Listeners for buttons
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("add")) {
			
		}
		if(e.getActionCommand().equals("update")) {
			updated = true;
		}
		if(e.getActionCommand().equals("x")) {
			System.exit(-1);
		}
	}
	/**
	 * To edit the fonts for themes
	 * @param font & font color
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
    	
    	return panel;
    }
    protected Font getGameFont() {
    	return textInputFieldFont;
    }
    protected Color getGameFontColor() {
    	return textInputFieldColor;
    }
	/*
	 * To Test this panel
	 */
    public static void main(String args[]) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
        new TextInputFieldContestant().setVisible(true);
            }
        });
    }

}
