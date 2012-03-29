/**
 * Reusable text fields class
 *  Various Combo Boxes store values that have been inputted
 *  Includes a photo uploader
 * Buttons to Add/Update/Delete Profiles
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/01/12
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
	private JComboBox playerComboBox, contestantComboBox;
    private JLabel recordDisplay;
    private ImageIcon uploadedImage;
    private Font regularFont, italicFont, textInputFieldFont;
    private Color textInputFieldColor;
    private boolean updated = false;
    private JLabel[] cLabels, pLabels;
    private JPanel recordPanel;
    private Player[] players;
    private Contestant[] contestants;
    private int numConts;
    
    final static int GAP = 10;
    
    
    
    
    ////stuff added
    private String pID, cID;
    
    
    /**************  Constructor *************************/
    public TextInputFields(Contestant[] conts, int numConts, Player[] players) {
    	super(new FlowLayout(FlowLayout.LEADING));
    	this.contestants=conts;
    	this.numConts=numConts;
    	this.players=players;
    	createFieldsPlayer();
    	createFieldsCont();
    }
    
    /**************  Methods ***********************/
   
    /**
     * Gets the first name of the player
     * @return first name
     */
	public String getFirstP() {
		return firstFieldP.getText();
	}

	/**
	 *  Gets the last name of the player
	 * @return last name
	 */
	public String getLastP() {
		return lastFieldP.getText();
	}
	

	/**
	 * Gets the first name of the contestant
	 * @return first name
	 */
	public String getFirstC() {
		return firstFieldC.getText();
	}

	/**
	 * Gets the last name of the contestant
	 * @return last name
	 */
	public String getLastC() {
		return lastFieldC.getText();
	}

	/**
	 * Gets the tribe name
	 * @return tribe name
	 */
	public String getTribe() {
		return tribeField.getText();
	}

	public void setFirstC(String input) {
		firstFieldC.setText(input);
	}

	public void setLastC(String input) {
		lastFieldC.setText(input);
	}

	public void setTribe(String input) {
		tribeField.setText(input);
	}

	public void setFirstP(String input) {
		firstFieldP.setText(input);
	}

	public void setLastP(String input) {
		lastFieldP.setText(input);
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
    
    /**
     * JComboBox of current players - appears once games starts
     * @return a combobox of all current Players
     */
    public JComponent playerDropDownList(Player[] plyrs) {
    	players=plyrs;
    	if(players!=null){
	    	String[] nameStrings = new String[players.length];
	    	for(int i=0;i<players.length;i++){
	    		nameStrings[i]=""+players[i].getID()+" - "+players[i].getFirst()+" "+players[i].getLast();
	    	}
	    	
	    	playerComboBox = new JComboBox(nameStrings);
	    	playerComboBox.setSelectedItem("Select from a list of current players");
	    	playerComboBox.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {    			
	    			firstFieldP.setText(players[playerComboBox.getSelectedIndex()].getFirst()); 
	    			lastFieldP.setText(players[playerComboBox.getSelectedIndex()].getLast());
	    			pID=players[playerComboBox.getSelectedIndex()].getID();
	    		}
	    	});
    	} else
    		playerComboBox=new JComboBox();
	    	JPanel p = new JPanel();
	    	p.add(playerComboBox);
	    	return p;
    }
    
    public String getMenuPlayerID() {
    	return pID;
    }
    
    public String getMenuContsID() {
    	return cID;
    }
    /**
     * JComboBox of current contestants - appears once games starts
     * @return a combobox of all current Contestants
     */
    public JComponent contestantDropDownList(Contestant[] conts, int numConts) {
    	contestants=conts;
    	if(contestants!=null) {
	    	String[] strings = new String[numConts];
	    	for(int i=0;i<numConts;i++){
	    		strings[i]=""+contestants[i].getID()+" - "+contestants[i].getFirst()+" "+contestants[i].getLast();
	    	}
	    	contestantComboBox = new JComboBox(strings);
	    	contestantComboBox.setSelectedItem("Select from a list of current contestants");
	    	contestantComboBox.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {    			
	    			firstFieldC.setText(contestants[contestantComboBox.getSelectedIndex()].getFirst());
	    			lastFieldC.setText(contestants[contestantComboBox.getSelectedIndex()].getLast());
	    			tribeField.setText(contestants[contestantComboBox.getSelectedIndex()].getID());
	    			cID=players[playerComboBox.getSelectedIndex()].getID();
	    		}
	    	});
    	} else
    		contestantComboBox=new JComboBox();
	    	JPanel c = new JPanel();
	    	c.add(contestantComboBox, BorderLayout.LINE_START);
	    	return c;
    }
    
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

    
    
    
}// End of Class