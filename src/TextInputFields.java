/**
 * Reusable text fields class
 *  Various Combo Boxes store values that have been inputted
 *  Includes a photo uploader
 * Buttons to Add/Update/Delete Profiles
 * @author hrivera
 * V 1.0 feb.19, 2012
 *
 */
 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;
 
/**
 * TextInputDemo.java uses these additional files:
 *   SpringUtilities.java
 *   ...
 */
public class TextInputFields extends JPanel implements ActionListener {
	/************   Attributes ***************************/
    private JTextField firstNameField, lastNameField, uniqueIDField, tribeField;
    private JSpinner firstNameSpinner, lastNameSpinner, uniqueIDSpinner, TribeSpinner;
    private JButton uploadBtn, updateBtn, addBtn, deleteBtn, resetBtn;
    private JLabel recordDisplay;
    private ImageIcon uploadedImage;
    private Font regularFont, italicFont, textInputFieldFont;
    private Color textInputFieldColor;
    private boolean updated = false;
    private JLabel[] labels;
    private JPanel recordPanel;
    
    final static int GAP = 10;
    
    /**************  Constructor *************************/
    public TextInputFields() {
    	super(new FlowLayout(FlowLayout.LEADING));
    	createNameFields();
    }
    
    /**************  Methods ***********************/
    /**
     * The Standard buttons for list input/update area
     * addBtn: Adds the info to the appropriate registeer
     * deleteBtn: Finds and Deletes the record enitrely from its register
     * updateBtn: Finds the record and allows user to make changes to any field
     * resetBtn: Clears all fields
     * @param op
     * @return 4 buttons floating right to left Add/Update/Remove/Reset
     */
    protected JComponent addUpdateDeleteButtons(String op) {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    	
    	addBtn = new JButton("Add " + op);
    	addBtn.setActionCommand("+");
    	addBtn.addActionListener(this);
    	
    	panel.add(addBtn);
    	
    	deleteBtn = new JButton("Delete " + op);
    	deleteBtn.setActionCommand("delete");
    	deleteBtn.addActionListener(this);
    	
    	panel.add(deleteBtn);
    	
    	updateBtn = new JButton("Update " + op);
    	updateBtn.setActionCommand("update");
    	updateBtn.addActionListener(this);
    	
    	panel.add(updateBtn);
    	
    	resetBtn = new JButton("Reset");
    	resetBtn.setActionCommand("reset");
    	resetBtn.addActionListener(this);
    	
    	panel.setOpaque(false);
    	panel.add(resetBtn);
    	
    	//Match the SpringLayout's gap, subtracting 5 to make
        //up for the default gap FlowLayout provides.
    	panel.setBorder(BorderFactory.createEmptyBorder(0,0,GAP-5,GAP-5));
    	
    	return panel;
    }
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
     * Format the image - resize to specifications
     * & uploaded into the image icon frame
     * This object will be used throughout the program as the image of the contestant
     */
    protected void createContestantImage() {
    	
    }
    /**
     * Button Handler for actions performed on string matched keys
     */
    public void actionPerformed(ActionEvent e) {
    	/**  Add+ Button Handler **/
    	if(e.getActionCommand().equals("+")) {
    		if(firstNameField.getText().equals("") && lastNameField.getText().equals("") && uniqueIDField.getText().equals(""))
    			JOptionPane.showMessageDialog(null, "Fields cannot be blank.", null, JOptionPane.WARNING_MESSAGE, null);
    		else {
    			// Add Record ***** TO DO ******
    			// Add To Spinner
    			JOptionPane.showMessageDialog(null, "Item Added Successfully.",null, JOptionPane.INFORMATION_MESSAGE);
    			firstNameField.selectAll();
    			lastNameField.selectAll();
    			uniqueIDField.selectAll();
    		}
    	}
    	/**  Update Button Handler **/
    	else if(e.getActionCommand().equals("update")) {
    		
    	}
    	/**  Delete Button Handler **/
    	else if(e.getActionCommand().equals("delete")) {
    		
    	}
    	/**  Reset Button Handler  **/
    	else if(e.getActionCommand().equals("reset")) {
    		if(firstNameField.getText() != "" || lastNameField.getText() !=  " " || uniqueIDField.getText() != " " || tribeField.getText() != " ") {
    		firstNameField.setText("");
    		lastNameField.setText("");
    		uniqueIDField.setText("");
    		tribeField.setText("");    		
    		}
    	}
    	/**  Upload Button Handler  **/
    	else if(e.getActionCommand().equals("upload")) {
    		
    	}
    	
    }// End of ActionPerformed Button Handler
    /**
     * Update Record
     */
    protected void updateRecord() {
    	
    }
    /**
     * Add New Record
     */
    protected void addNew() {
    	
    }
    /**
     * Updates a formatted display of the record added or edited
     */
    protected void updateDisplays() {
    	recordDisplay.setText(formatField());
    	if(updated) {
    		recordDisplay.setFont(regularFont);
    	} else {
    		recordDisplay.setFont(italicFont);
    	}
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
    * Formats the text fields to the within project specifications
    */
    protected String formatField() {
    	if(!updated) return " \nNo record set.";
    	
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
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
     * Generates a unique player ID
     * Unique userid - this id should be the same as the western userid: first initial, 
     * Player:  last name up to 6 character and then a number 
     *   		if that first initial and 1-6 characters are already used
     *   		@return 6(+a possible number) character string
     * Contestant: case insensitive
     * 			@return 2 character string
     * @param firstName, lastName, desired length of ID
     * @return a unique ID
     */
    private String uniqueIDGenerator(String firstName, String lastName, int output) {
    	String uniqueID = "";
    	
    	if(output ==2) {	// Generate ID for contestants
    		
    	} else {  			// Generate ID for players
    		
    	}
    	return uniqueID;
    }
    
    //A convenience method for creating a MaskFormatter.
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
 
    /**
     * Called when one of the fields gets the focus so that
     * we can select the focused field.
     */
    public void focusGained(FocusEvent e) {
        Component c = e.getComponent();
        if (c instanceof JFormattedTextField) {
            selectItLater(c);
        } else if (c instanceof JTextField) {
            ((JTextField)c).selectAll();
        }
    }
 
    //Workaround for formatted text field focus side effects.
    protected void selectItLater(Component c) {
        if (c instanceof JFormattedTextField) {
            final JFormattedTextField ftf = (JFormattedTextField)c;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ftf.selectAll();
                }
            });
        }
    }
 
    //Needed for FocusListener interface.
    public void focusLost(FocusEvent e) { } //ignore
    
    /**
     * General Entry Text Fields
     * @return First & Last name & Unique ID Text Fields
     */
    public JComponent createNameFields() {
    	JPanel namePanel = new JPanel(new SpringLayout());
    	
    	String[] labelStrings = {
    			"User ID: ",
    			"First Name: ",
    			"Last Name: "    			
    	};
    	
    	labels = new JLabel[labelStrings.length];
    	JComponent[] fields = new JComponent[labelStrings.length];
    	int fieldNum = 0;
    	
    	// Create the text field & set it up
    	uniqueIDField = new JTextField(uniqueIDGenerator("","",6)); /*****  Must fix this upon implementation *****/
    	uniqueIDField.setColumns(9);
    	fields[fieldNum++] = uniqueIDField;
    	
    	firstNameField = new JTextField();
    	firstNameField.setColumns(20);
    	fields[fieldNum++] = firstNameField;
    	
    	lastNameField = new JTextField();
    	lastNameField.setColumns(20);
    	fields[fieldNum++] = lastNameField;
    	
    	namePanel.setOpaque(false);
    	
    	//Associate label/field pairs, add everything and lay it out
    	for(int i=0; i<labelStrings.length;i++) {
    		labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
    		labels[i].setLabelFor(fields[i]);
    		namePanel.add(labels[i]);
    		namePanel.add(fields[i]);
    		
    		// for each field, create a spinner for every entry added
    		/******  To Do  ********/
    	}
    	SpringUtilities.makeCompactGrid(namePanel, labelStrings.length, 2, 
    									GAP, GAP, //init x,y
    									GAP, GAP/2); //xpad, ypad
    	return namePanel; 	    	
    }
    public JLabel[] getLabel() {
    	return this.labels;
    }
    /**
     * A panel for Contestant entry fields - Tribe Name, a JSpinner is created when entries are made
     * @return Tribe Name text field & JSpinner
     */
    protected JComponent createTribeField() {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    	
    	JLabel label = new JLabel("Tribe Name:   ");
    	
    	tribeField = new JTextField();
    	tribeField.setColumns(31);
    	JComponent tField = tribeField;
    	
    	// Assemble the panel
    	label.setLabelFor(tField);
    	panel.setOpaque(false);
    	panel.add(label);
    	panel.add(tField);
    	
    	// Add the Spinner
    	/*****  To Do  ******/
    	
    	 //Match the SpringLayout's gap, subtracting 5 to make
        //up for the default gap FlowLayout provides.
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                                                GAP-5, GAP-5));
        return panel;  	    	
    }
    /**
     * Find Entry from any Text Field Spinner
     */
    public void find(String searchTerm) {
    	// Get the string from the textfield
    	// Search the records
    }    
    /**
     * The textfield spinners
     * The strings inputed in the textfields are stored as search terms  in the spinner
     */
    public JFormattedTextField getTextField(JSpinner spinner) {
    	JComponent editor = spinner.getEditor();
    	if(editor instanceof JSpinner.DefaultEditor) {
    		return((JSpinner.DefaultEditor)editor).getTextField();
    	} else {
    		System.err.println("Unexpected editor type: "
    							+ spinner.getEditor().getClass()
    							+ " isn't a descendant DefaultEditor");
    		return null;
    	}
    }

    protected JComponent setGameFont(Font font, Color color) {
    	this.textInputFieldFont = font;
    	this.textInputFieldColor = color;

    	JPanel panel = new JPanel();
    	
    	JLabel id = labels[0];
    	id.setFont(font);
    	id.setForeground(color);
    	
    	JLabel first = labels[1];
    	first.setFont(font);
    	first.setForeground(color);
    	
    	JLabel last = labels[2];
    	last.setFont(font);
    	last.setForeground(color);
    	
    	return panel;
    }
    protected Font getGameFont() {
    	return textInputFieldFont;
    }
    protected Color getGameFontColor() {
    	return textInputFieldColor;
    }

 
    
    
    
}// End of Class