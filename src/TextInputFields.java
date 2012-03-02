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
import java.io.*;
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static JTextField firstFieldP, lastFieldP, tribeField, firstFieldC, lastFieldC;
	private String firstNameString = "", lastNameString = "", tribeString = "";  // Record Display String
    private JButton uploadBtn, updateBtn, addBtn, deleteBtn, resetBtn;
    private JLabel recordDisplay;
    private ImageIcon uploadedImage;
    private Font regularFont, italicFont, textInputFieldFont;
    private Color textInputFieldColor;
    private boolean updated = false;
    private JLabel[] cLabels, pLabels;
    private JPanel recordPanel;
    
    final static int GAP = 10;
    
    /**************  Constructor *************************/
    public TextInputFields() {
    	super(new FlowLayout(FlowLayout.LEADING));
    	createFieldsPlayer();
    	createFieldsCont();
    }
    
    /**************  Methods ***********************/
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getFirstP(){
    	return firstFieldP.getText();

    }

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getLastP() {
    	return lastFieldP.getText();

    }
    
    public String getFirstC(){
    	return firstFieldC.getText();
    	}
    	public String getLastC(){
    	return lastFieldC.getText();
    	}
    	public String getTribe(){
    	return tribeField.getText();
    	}

    	public void setFirstC(String input){
    	firstFieldC.setText(input);
    	}

    	public void setLastC(String input){
    	lastFieldC.setText(input);
    	}
    	public void setTribe(String input){
    	tribeField.setText(input);
    	}


    	public void setFirstP(String input){
    	firstFieldP.setText(input);
    	}

    	public void setLastP(String input){
    	lastFieldP.setText(input);
    	}
//    /**
//     * This button allows the user to upload a pic from file and it will fit the image into a special frame
//     * depending on the theme.
//     * @return upload button
//     */
//    protected JComponent uploadButton() {
//    	JPanel p = new JPanel();
//    	
//    	uploadedImage = new ImageIcon(getClass().getResource("images/uploadPicFrame_Goldblank.jpg"), "No Contestant Image has been loaded yet.");
//    	
//    	uploadBtn = new JButton("Upload a Picture", uploadedImage);
//    	uploadBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
//    	uploadBtn.setHorizontalTextPosition(AbstractButton.CENTER);
//    	uploadBtn.setActionCommand("upload");
//    	uploadBtn.addActionListener(this);
//    	
//    	p.setOpaque(false);
//    	p.add(uploadBtn);
//    	return p;
//    }
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
    		if(firstFieldP.getText().equals("") && lastFieldP.getText().equals("") || firstFieldC.getText().equals("") && lastFieldC.getText().equals(""))
    			JOptionPane.showMessageDialog(null, "Fields cannot be blank.", null, JOptionPane.WARNING_MESSAGE, null);
    		else {
    			// Add Record ***** TO DO ******
    			// Add To Spinner
    			JOptionPane.showMessageDialog(null, "Item Added Successfully.",null, JOptionPane.INFORMATION_MESSAGE);
    			firstFieldP.selectAll();
    			lastFieldP.selectAll();
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
    		if(firstFieldP.getText() != "" || lastFieldP.getText() !=  " ") {
    			firstFieldP.setText("");
    			firstFieldP.setText("");
    		}
    		if(firstFieldC.getText() != "" || lastFieldC.getText() !=  " ") {
    			firstFieldC.setText("");
    			lastFieldC.setText("");
        		tribeField.setText("");  
    		}
    	}
//    	/**  Upload Button Handler  **/
//    	else if(e.getActionCommand().equals("upload")) {
//    		JFileChooser fileChooser = new JFileChooser();
//    		int returnVal = fileChooser.showOpenDialog(this);
//    		if (returnVal == JFileChooser.APPROVE_OPTION){
//    		File contestantPhoto = fileChooser.getSelectedFile();
//    		}
//    	}
//    	
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
    	if(!updated) return "No record set.";
    	
    	if(firstFieldP.getText() != null && lastFieldP.getText() != null)  {
	    	firstNameString = firstFieldP.getText();
	    	lastNameString = lastFieldP.getText();
    	} else	{
        	firstNameString = firstFieldC.getText();
        	lastNameString = lastFieldC.getText();
        	tribeString = tribeField.getText();	
    	}
//    	String empty = "";
//    	
//    	if((firstName == null) || empty.equals(firstName)) {
//    		firstName = "<em>(no first name specified)</em>";
//    		//+ must be 1-20 letters
//    	}
//    	if((lastName == null) || empty.equals(lastName)) {
//    		lastName = "<em>(no last name specified)</em>";
//    		//+ must be 1-20 letters
//    	}
//    	if((firstName == null) || empty.equals(firstName)) {
//    		firstName = "<em>(no first name specified)</em>";
//    	}
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append("<html><p align=center>");
    	sb.append(firstNameString);
    	sb.append(" ");
    	sb.append(lastNameString);
//    	sb.append(uniqueID); // TODO Append to display panel with a unique id getter
    	sb.append("<br>");
    	sb.append(tribeString);
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
     * General Entry Text Fields for player
     * @return First & Last name & Unique ID Text Fields
     */
    public JComponent createFieldsPlayer() {
    	JPanel namePanel = new JPanel(new SpringLayout());
    	
    	String[] labelStrings = {
//    			"User ID: ",
    			"First Name: ",
    			"Last Name: "    			
    	};
    	
    	pLabels = new JLabel[labelStrings.length];
    	JComponent[] fields = new JComponent[labelStrings.length];
    	int fieldNum = 0;
    	
    	firstFieldP = new JTextField();
    	firstFieldP.setColumns(20);
    	fields[fieldNum++] = firstFieldP;
    	
    	lastFieldP = new JTextField();
    	lastFieldP.setColumns(20);
    	fields[fieldNum++] = lastFieldP;
    	
    	namePanel.setOpaque(false);
    	
    	//Associate label/field pairs, add everything and lay it out
    	for(int i=0; i<labelStrings.length;i++) {
    		pLabels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
    		pLabels[i].setLabelFor(fields[i]);
    		namePanel.add(pLabels[i]);
    		namePanel.add(fields[i]);
    		
    		// for each field, create a spinner for every entry added
    		/******  To Do  ********/
    	}
    	SpringUtilities.makeCompactGrid(namePanel, labelStrings.length, 2, 
    									GAP, GAP, //init x,y
    									GAP, GAP/2); //xpad, ypad
    	return namePanel; 	    	
    }
    /**
     * General Entry Text Fields for player
     * @return First & Last name & Unique ID Text Fields
     */
    public JComponent createFieldsCont() {
    	JPanel namePanel = new JPanel(new SpringLayout());
    	
    	String[] labelStrings = {
    			"First Name: ",
    			"Last Name: ",
    			"Tribe Name: "
    	};
    	
    	cLabels = new JLabel[labelStrings.length];
    	JComponent[] fields = new JComponent[labelStrings.length];
    	int fieldNum = 0;
    	
    	firstFieldC = new JTextField();
    	firstFieldC.setColumns(20);
    	fields[fieldNum++] = firstFieldC;
    	
    	lastFieldC = new JTextField();
    	lastFieldC.setColumns(20);
    	fields[fieldNum++] = lastFieldC;
    	
    	tribeField = new JTextField();
    	tribeField.setColumns(31);
    	fields[fieldNum++] = tribeField;
    	
    	namePanel.setOpaque(false);
    	
    	//Associate label/field pairs, add everything and lay it out
    	for(int i=0; i<labelStrings.length;i++) {
    		cLabels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
    		cLabels[i].setLabelFor(fields[i]);
    		namePanel.add(cLabels[i]);
    		namePanel.add(fields[i]);   		
    	}
    	
    	SpringUtilities.makeCompactGrid(namePanel, labelStrings.length, 2, 
    									GAP, GAP, //init x,y
    									GAP, GAP/2); //xpad, ypad
    	return namePanel; 	    	
    }  
//    /**
//     * The textfield spinners
//     * The strings inputed in the textfields are stored as search terms  in the spinner
//     */
//    public JFormattedTextField getTextField(JSpinner spinner) {
//    	JComponent editor = spinner.getEditor();
//    	if(editor instanceof JSpinner.DefaultEditor) {
//    		return((JSpinner.DefaultEditor)editor).getTextField();
//    	} else {
//    		System.err.println("Unexpected editor type: "
//    							+ spinner.getEditor().getClass()
//    							+ " isn't a descendant DefaultEditor");
//    		return null;
//    	}
//    }

    protected JComponent setGameFontP(Font font, Color color) {
    	this.textInputFieldFont = font;
    	this.textInputFieldColor = color;

    	JPanel panel = new JPanel();
    	
    	JLabel first = pLabels[0];
    	first.setFont(font);
    	first.setForeground(color);
    	
    	JLabel last = pLabels[1];
    	last.setFont(font);
    	last.setForeground(color);
    	
    	return panel;
    }
    protected JComponent setGameFontC(Font font, Color color) {
    	this.textInputFieldFont = font;
    	this.textInputFieldColor = color;

    	JPanel panel = new JPanel();
    	
    	JLabel first = cLabels[0];
    	first.setFont(font);
    	first.setForeground(color);
    	
    	JLabel last = cLabels[1];
    	last.setFont(font);
    	last.setForeground(color);
 
    	JLabel tribe = cLabels[2];
    	tribe.setFont(font);
    	tribe.setForeground(color);
    	
    	return panel;
    }
    protected Font getGameFont() {
    	return textInputFieldFont;
    }
    protected Color getGameFontColor() {
    	return textInputFieldColor;
    }

    public static void main(String args[]) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
        new TextInputFields().setVisible(true);
            }
        });
    }
    
    
    
}// End of Class