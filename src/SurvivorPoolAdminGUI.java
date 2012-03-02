/**
 * The administrative interface 
 * The look & feel 
 * @author hrivera
 * V 1.0 02/18/12
 */
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;

public class SurvivorPoolAdminGUI extends JFrame implements ActionListener {
	/****************************** Attributes ***************************************/
	// The default measurements for the main window
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
    final static int GAP = 20;

	// Images
//	private ImageIcon survivorLogoImg = createImageIcon("images/survivorLogo.png");
	private ImageIcon title, quitImg, mainMenuBtnImg;
	private ImageIcon goldBackground = createImageIcon("images/ruins.jpg"), jungleBackground;
	private ImageIcon newGame, playerBtnImg, playersJungleImg, playersGoldImg = createImageIcon("images/bbG.png"), contestantImg, stadingsImg, bonusQImg, themeSelectImg;
	private ImageIcon playerJBg, playerGBg, contestantJBg, contestantGBg, standingGBg, standingJBg, bqGBg, bqJBg, blankGFrame, blankJFrame;
	private ImageIcon uploadedImage;
	
	// Buttons
	private JButton quitBtn, mainMenuBtn, createNewGameBtn, playersBtn, contestantsBtn, standingsBtn, bonusQBtn, themeSelectBtn;	
	private JButton addBtn, updateBtn, deleteBtn, resetBtn, uploadBtn;
	
	// JLabels
	private JLabel themeMaker = new JLabel(goldBackground), playerBg, contestantBg, standingBg, bqBg, titleBanner, contestantPicFrame;
	
	// For the standings Panel
	private JLabel poolLabel, currWkLabel, numContLabel, recElimLabel;  
	private JTextArea poolArea, currWkArea, numContArea, recElimArea;
	
	private String currWkString = "Current Week: ";
	
	// JPanels
	private JPanel mainPanel, quitPanel, mMenuBtnPanel, titlePanel, mainButtonsPanel, pPanel, cPanel, sPanel, qPanel;
	
	private TextInputFields textFields_p, textFields_c;
	
	private PlayerListGUI standingsTable;
	
	private Font gFont, jFont;
	
	//contestant and player holder
	private Player[] players;
	private Contestant[] contestants;
	private int contCount = 0;

	/******************************** Constructor *************************************/
	public SurvivorPoolAdminGUI() {	
		//initialize players and contestants array
		String fileName="players.txt";
		readPlayers(fileName);
		contestants=null;
		
		textFields_p = new TextInputFields();
		textFields_c = new TextInputFields();
		standingsTable = new PlayerListGUI();
		
		// Font for the Golden Ruin Theme
		gFont = new Font("Pescadero",Font.PLAIN,18);
		// The jungle theme font
		jFont = new Font("Viner Hand ITC",Font.PLAIN,18);

		// Call all set the backgrounds for each panel
		playerGBg = createImageIcon("images/playerGoldenBg.jpg");
		playerBg = new JLabel(playerGBg);
		
		contestantGBg = createImageIcon("images/contestantGoldenBg.jpg");
		contestantBg = new JLabel(contestantGBg);
		
		blankGFrame = createImageIcon("images/uploadPicFrame_goldFrame.png");
		contestantPicFrame = new JLabel(blankGFrame);
		
		standingGBg = createImageIcon("images/standingsGolden.jpg");
		standingBg = new JLabel(standingGBg);
		
		bqGBg = createImageIcon("images/bqGolden.jpg");
		bqBg = new JLabel(bqGBg);

		SpringLayout guiLayout = new SpringLayout();	
        this.setLayout(guiLayout);
        
        this.setJMenuBar(menuBar());

        getContentPane().add(quitButton());
        getContentPane().add(mainScreen());	

        guiLayout.putConstraint(SpringLayout.WEST, quitPanel, 40, SpringLayout.WEST, getContentPane());
	    guiLayout.putConstraint(SpringLayout.NORTH, quitPanel, 40, SpringLayout.NORTH, getContentPane());
       
	    guiLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, getContentPane());
	    guiLayout.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, getContentPane());
  
	    goldenRuinsTheme(); // Set the default theme

        // Set up methods for the frame
        this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("UWOSurvivorPoolAdmin");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		 	
	}// End of SurvivorPoolAdminGUI Constructor
	
	/******************************  Methods  *********************************/
	
	public void readPlayers(String fileName){
        try{
            DataInputStream input = new DataInputStream(new FileInputStream(fileName));
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String currPlayer = in.readLine(), firstName="", lastName="", userID="";
            Player currPlayerObj;
            Boolean first, last, ID;
            first=last=ID=false;
            while(currPlayer!=null){
            for(int i=0; i<currPlayer.length(); i++){
                char ch=currPlayer.charAt(i);
                System.out.print(ch);
                if(!first){
                	if(ch=='+')
                		first=true;
                	else
                		firstName=firstName+ch;
               }//end of first name field
                else if(!last && first){
                	if(ch=='+')
                		last=true;
                	else
                		lastName=lastName+ch;
               }//end of  last name field
                else if(!ID && last){
                	if(ch=='+')
                		ID=true;
                	else
                		userID=userID+ch;
               }//end of first last name field
               if(ID && (last && first)){
               currPlayerObj=new Player(firstName, lastName, userID);
               addPlayer(currPlayerObj);
               break;
               }
            }//end of scanning through currplayer
            first=last=ID=false;
            firstName=lastName=userID="";
            currPlayer=in.readLine();
            }//end of currplayer
        }
        catch(IOException e){}//unharmful
	}
	
	public void writePlayers(String fileName){
        BufferedWriter bWr = null;
        String currString="";
        try {
            
            bWr = new BufferedWriter(new FileWriter(fileName));
            for(int i=0;i<this.players.length;i++){
            	currString=currString+this.players[i].getFirst()+"+";
            	currString=currString+this.players[i].getLast()+"+";
            	currString=currString+this.players[i].getID()+"+";
            	currString=currString+"\n";
            }
            //Start writing to the output stream
            bWr.write(currString);
            bWr.flush();
            bWr.close();
	}
        catch(IOException e){}//unharmful
        
	}
	
	public void addPlayer(Player p){
		
		if(this.players==null){
			this.players=new Player[1];
			this.players[0]= p;
		}
		else{
			Player[] newPlayers=new Player[this.players.length+1];
			for(int i=0;i<this.players.length; i++){
				newPlayers[i]=this.players[i];
			}
			newPlayers[this.players.length] = p ;
			this.players=newPlayers;
		}
	}
	public Player[] getPlayers(){
		return this.players;
	}
/**
 * The menu bar
 * @return menu bar with menu items
 */
	private JMenuBar menuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu, editMenu, windowMenu;
		JMenuItem startGameItem, newItem, mainItem, quitItem, bonusQItem, playerItem, contestantItem, themeItem, statsItem, creditsItem;
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		windowMenu = new JMenu("Window");

		startGameItem = new JMenuItem("Game Settings");
		startGameItem.setActionCommand("settings");
		startGameItem.addActionListener(this);
		
		newItem = new JMenuItem("New");
		newItem.setActionCommand("new");
		newItem.addActionListener(this);
		
		mainItem = new JMenuItem("Main Menu");
		mainItem.setActionCommand("main");
		mainItem.addActionListener(this);
		
		quitItem = new JMenuItem("Quit");
		quitItem.setActionCommand("q");
		quitItem.addActionListener(this);
		
		bonusQItem = new JMenuItem("Bonus Question Window");
		bonusQItem.setActionCommand("bonus");
		bonusQItem.addActionListener(this);
		
		playerItem = new JMenuItem("Player Add/Edit Window");
		playerItem.setActionCommand("players");
		playerItem.addActionListener(this);
		
		contestantItem =  new JMenuItem("Contestant Add/Edit Window");
		contestantItem.setActionCommand("contestants");
		contestantItem.addActionListener(this);
		
		themeItem = new JMenuItem("Change Theme");
		themeItem.setToolTipText("Jungle Theme or Golden Ruins Theme");
		themeItem.setActionCommand("theme");
		themeItem.addActionListener(this);
				
		statsItem = new JMenuItem("See Player Stats");
		creditsItem = new JMenuItem("Credits");
		creditsItem.setToolTipText("Images Cited"); // Will appear in a dialog box
		
		fileMenu.add(newItem);
		fileMenu.add(mainItem);
		fileMenu.add(startGameItem);
		fileMenu.add(quitItem);		
		
		editMenu.add(bonusQItem);
		editMenu.add(playerItem);
		editMenu.add(contestantItem);
		
		windowMenu.add(statsItem);
		windowMenu.add(themeItem);
		windowMenu.addSeparator();
		windowMenu.add(creditsItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}
	private JComponent mainScreen() {
		SpringLayout guiLayout = new SpringLayout();	
		mainPanel = new JPanel(guiLayout);
	    this.setLayout(guiLayout);
	   
		getContentPane().add(mainButtons());		
	    getContentPane().add(titleComponent());
		getContentPane().add(quitButton());
	    getContentPane().add(themeMaker); // Set the default theme as Golden ruins
	
	    // Layout the components in the frame
	    guiLayout.putConstraint(SpringLayout.WEST, themeMaker, 0, SpringLayout.WEST, getContentPane());
	    guiLayout.putConstraint(SpringLayout.NORTH, themeMaker, 0, SpringLayout.NORTH, getContentPane());
	    	    
	    guiLayout.putConstraint(SpringLayout.WEST, titlePanel, 50, SpringLayout.WEST, getContentPane());
	    guiLayout.putConstraint(SpringLayout.NORTH, titlePanel, 30, SpringLayout.NORTH, getContentPane());
	    
	    guiLayout.putConstraint(SpringLayout.WEST, mainButtonsPanel, 60, SpringLayout.WEST, getContentPane());
	    guiLayout.putConstraint(SpringLayout.NORTH, mainButtonsPanel, 150, SpringLayout.NORTH, getContentPane());
	    
	    return mainPanel;
	    }// End of main panel 
	/**
	 * Main Screen Buttons
	 */
	protected JComponent mainButtons() {
		mainButtonsPanel = new JPanel(new GridLayout(2,3,60,30));
		
        // Create New Survivor Game Button 
        newGame = createImageIcon("images/newGame.png");	
        createNewGameBtn = new JButton("Create Survivor New Game", newGame);
        // Set the text position
        createNewGameBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        createNewGameBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        createNewGameBtn.setOpaque(false);
        createNewGameBtn.setFocusPainted(false);
        createNewGameBtn.setBorderPainted(false);
        createNewGameBtn.setContentAreaFilled(false);
        createNewGameBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        createNewGameBtn.setMnemonic(KeyEvent.VK_N);
        createNewGameBtn.setToolTipText("Create a New Survivor Pool");
        createNewGameBtn.setActionCommand("settings");
        createNewGameBtn.addActionListener(this);
        
        // Players List Button - Set Gold image as part of default theme
//        playersGoldImg = createImageIcon("images/bbG.png");
        playersBtn = new JButton("Players",playerBtnImg);
        // Set the text position
        playersBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        playersBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        playersBtn.setOpaque(false);
        playersBtn.setFocusPainted(false);
        playersBtn.setBorderPainted(false);
        playersBtn.setContentAreaFilled(false);
        playersBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        playersBtn.setMnemonic(KeyEvent.VK_P);
        playersBtn.setToolTipText("Players List");
        playersBtn.setActionCommand("players");
        playersBtn.addActionListener(this);
       
        // Contestants List Button
        contestantImg = createImageIcon("images/contestants.png");	
        contestantsBtn = new JButton("Contestants",contestantImg);
        // Set the text position
        contestantsBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        contestantsBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        contestantsBtn.setOpaque(false);
        contestantsBtn.setFocusPainted(false);
        contestantsBtn.setBorderPainted(false);
        contestantsBtn.setContentAreaFilled(false);
        contestantsBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        contestantsBtn.setMnemonic(KeyEvent.VK_C);
        contestantsBtn.setToolTipText("Contestants List");
        contestantsBtn.setActionCommand("contestants");
        contestantsBtn.addActionListener(this);
        
        // Standings List Button
        stadingsImg = createImageIcon("images/standings.png");
        standingsBtn = new JButton("Current Standings",stadingsImg);
        // Set the text position
        standingsBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        standingsBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        standingsBtn.setOpaque(false);
        standingsBtn.setFocusPainted(false);
        standingsBtn.setBorderPainted(false);
        standingsBtn.setContentAreaFilled(false);
        standingsBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        standingsBtn.setMnemonic(KeyEvent.VK_S);
        standingsBtn.setToolTipText("Current Contest Standings");
        standingsBtn.setActionCommand("standings");
        standingsBtn.addActionListener(this);
        
        // Bonus Question Button
        bonusQImg = createImageIcon("images/bq.png");
        bonusQBtn = new JButton("Bonus Questions",bonusQImg);
        // Set the text position
        bonusQBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        bonusQBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        bonusQBtn.setOpaque(false);
        bonusQBtn.setFocusPainted(false);
        bonusQBtn.setBorderPainted(false);
        bonusQBtn.setContentAreaFilled(false);
        bonusQBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        bonusQBtn.setMnemonic(KeyEvent.VK_B);
        bonusQBtn.setToolTipText("Add & Edit Bonus Questions");
        bonusQBtn.setActionCommand("bonus");
        bonusQBtn.addActionListener(this);
        
        // Theme Selector Button
        themeSelectImg = createImageIcon("images/themeSelect.png");
        themeSelectBtn = new JButton("Select a Theme",themeSelectImg);
        // Set the text position
        themeSelectBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        themeSelectBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        // Set the button layout
        themeSelectBtn.setOpaque(false);
        themeSelectBtn.setFocusPainted(false);
        themeSelectBtn.setBorderPainted(false);
        themeSelectBtn.setContentAreaFilled(false);
        themeSelectBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        // Set Action Commands & Listeners
        themeSelectBtn.setMnemonic(KeyEvent.VK_T);
        themeSelectBtn.setToolTipText("Golden Ruins Theme or Jungle Theme");
        themeSelectBtn.setActionCommand("theme");
        themeSelectBtn.addActionListener(this);
		
		mainButtonsPanel.setOpaque(false);
		
		mainButtonsPanel.add(playersBtn);
		mainButtonsPanel.add(createNewGameBtn);
		mainButtonsPanel.add(contestantsBtn);
		mainButtonsPanel.add(standingsBtn);
		mainButtonsPanel.add(bonusQBtn);
		mainButtonsPanel.add(themeSelectBtn);
		
		return mainButtonsPanel;
	}
    /**
     * This button allows the user to upload a pic from file and it will fit the image into a special frame
     * depending on the theme.
     * @return upload button
     */
    protected JComponent uploadButton() {
    	JPanel p = new JPanel();
    	
    	uploadedImage = createImageIcon("images/uploadPicFrame_Goldblank.jpg");
    	
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
	 * The Title Banner
	 */
	protected JComponent titleComponent() {
		titlePanel = new JPanel();
		title = createImageIcon("images/title.png");
        titleBanner = new JLabel(title);
        titleBanner.setToolTipText("By Hazel R, Manor F, Jeff W, Liam C, Delerina H, Martin G");
        
        titlePanel.setOpaque(false);
        titlePanel.add(titleBanner);
        
        return titlePanel;
	}
	/**
	 * Main Menu Button
	 * @return a panel with a main menu button on it that changes dynamically depending on the theme
	 */
	protected JComponent mainMenuButton() {
		mMenuBtnPanel = new JPanel();
		mainMenuBtnImg = createImageIcon("images/mainMenuButton.png");
		mainMenuBtn = new JButton(mainMenuBtnImg);
		mainMenuBtn.setToolTipText("Return to the Main Menu  ALT+1");
		
        // Set the button layout
		mainMenuBtn.setOpaque(false);
		mainMenuBtn.setFocusPainted(false);
		mainMenuBtn.setBorderPainted(false);
		mainMenuBtn.setContentAreaFilled(false);
		mainMenuBtn.setBorder(BorderFactory.createEmptyBorder(GAP,GAP*4,GAP,GAP));
		
		mMenuBtnPanel.setOpaque(false);
		
		mainMenuBtn.setMnemonic(KeyEvent.VK_1);
		mainMenuBtn.setActionCommand("main");
		mainMenuBtn.addActionListener(this);
		
		mMenuBtnPanel.add(mainMenuBtn);

		return mMenuBtnPanel;
	}	
	/**
	 * The Quit button
	 */
	protected JComponent quitButton() {
		quitPanel = new JPanel();
		
		// Quit Button
		quitImg = createImageIcon("images/Quit-icon.png");
		quitBtn = new JButton(quitImg);
		
        // Set the button layout
		quitBtn.setOpaque(false);
		quitBtn.setFocusPainted(false);
		quitBtn.setBorderPainted(false);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
		
        // Set the button panel layout
		quitPanel.setOpaque(false);
		
		// Set Action Commands
		quitBtn.setMnemonic(KeyEvent.VK_Q);
		quitBtn.setToolTipText("Quit");
		
		quitBtn.setActionCommand("q");
        quitBtn.addActionListener(this);
        
        quitPanel.add(quitBtn);
        
        return quitPanel;
    }
//	/**
//	 * Current Week Panel
//	 */
//	protected JComponent currentWkPane() {
//		
//	}

	/**
	 * Bonus Question Panel
	 * A Bonus Q&A Input Area
	 */
	private JComponent bqPanel() {
		qPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		getContentPane().add(qPanel);
	    getContentPane().add(mainMenuButton());
		getContentPane().add(bqBg); 		// Create the background		
		
		return qPanel;

	}
	/**
	 * Standings Panel
	 * A Chart and current information
	 */
	protected JComponent standingsPanel() {
		SpringLayout sLayout = new SpringLayout();
		sPanel = new JPanel(sLayout);
	    this.setLayout(sLayout);
	    
		// Add the list
		JPanel centerPanel = new JPanel();
		centerPanel.add(standingsTable.createPlayerList(), BorderLayout.CENTER);
		
		getContentPane().add(sPanel);
	    getContentPane().add(mainMenuButton());
	    getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(standingBg); 		// Create the background		
		

		// Create the labels and text areas for this panel
		String poolString = "Total in Pool";
		
		JLabel poolLabel, currWkLabel, numContLabel, recElimLabel;  
//		private JTextArea poolArea, currWkArea, numContArea, recElimArea;
		
		return sPanel;
	}
    /**
     * The Standard buttons for list input/update area
     * addBtn: Adds the info to the appropriate register
     * deleteBtn: Finds and Deletes the record enitrely from its register
     * updateBtn: Finds the record and allows user to make changes to any field
     * resetBtn: Clears all fields
     * @param op
     * @return 4 buttons floating right to left Add/Update/Remove/Reset
     */
    protected JComponent addUpdateDeleteButtons(String op) {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    	
    	addBtn = new JButton("Add " + op);
    	addBtn.setActionCommand("+P");
    	addBtn.addActionListener(this);
    	
    	panel.add(addBtn);
    	
    	deleteBtn = new JButton("Delete " + op);
    	deleteBtn.setActionCommand("deleteP");
    	deleteBtn.addActionListener(this);
    	
    	panel.add(deleteBtn);
    	
    	updateBtn = new JButton("Update " + op);
    	updateBtn.setActionCommand("updateP");
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
    protected JComponent addUpdateDeleteButtonsC(String op) {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    	
    	addBtn = new JButton("Add " + op);
    	addBtn.setActionCommand("+C");
    	addBtn.addActionListener(this);
    	
    	panel.add(addBtn);
    	
    	deleteBtn = new JButton("Delete " + op);
    	deleteBtn.setActionCommand("deleteC");
    	deleteBtn.addActionListener(this);
    	
    	panel.add(deleteBtn);
    	
    	updateBtn = new JButton("Update " + op);
    	updateBtn.setActionCommand("updateC");
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
	 * Players Edit, Add & Store Panel/Screen
	 */
	protected JComponent playersPanel() {
		pPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				
		JPanel leftHalf_p = new JPanel();
		leftHalf_p.setLayout(new BoxLayout(leftHalf_p, BoxLayout.PAGE_AXIS));	
		leftHalf_p.add(textFields_p.createFieldsPlayer());
		leftHalf_p.add(addUpdateDeleteButtons("Player"));
		leftHalf_p.setOpaque(false);

		// Create a separator
		leftHalf_p.setBorder(BorderFactory.createEmptyBorder(	GAP/4, //top
												                0,     //left
												                GAP/4, //bottom
												                0));   //right
		leftHalf_p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		leftHalf_p.setPreferredSize(new Dimension(492,580));
	    
		pPanel.setOpaque(false);
		pPanel.add(leftHalf_p);
		pPanel.add(textFields_p.createRecordDisplay(), BorderLayout.CENTER);
		
		// Assemble the text fields with the background as a large panel
		SpringLayout pLayout = new SpringLayout();
		JPanel playerPanel = new JPanel(pLayout);
	    this.setLayout(pLayout);
		
	    getContentPane().add(mainMenuButton());
		getContentPane().add(pPanel);
		getContentPane().add(playerBg);

	    pLayout.putConstraint(SpringLayout.WEST, playerBg, 0, SpringLayout.WEST, getContentPane());
	    pLayout.putConstraint(SpringLayout.NORTH, playerBg, 0, SpringLayout.NORTH, getContentPane());

	    pLayout.putConstraint(SpringLayout.WEST, mMenuBtnPanel, 0, SpringLayout.WEST, getContentPane());
	    pLayout.putConstraint(SpringLayout.NORTH, mMenuBtnPanel, 0, SpringLayout.NORTH, getContentPane());
	    
	    pLayout.putConstraint(SpringLayout.WEST, pPanel, GAP*2, SpringLayout.WEST, getContentPane());
	    pLayout.putConstraint(SpringLayout.NORTH, pPanel, 150, SpringLayout.NORTH, getContentPane());

		return playerPanel;
	}
	/**
	 * Contestants Edit, Add & Store Panel/Screen
	 */
	protected JComponent contestantPanel() {
		cPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				
		JPanel leftHalf_c = new JPanel();
		leftHalf_c.setLayout(new BoxLayout(leftHalf_c, BoxLayout.PAGE_AXIS));
		leftHalf_c.setOpaque(false);
		leftHalf_c.add(textFields_c.createFieldsCont());
//	    leftHalf_c.add(textFields_c.createTribeField());
	    leftHalf_c.add(uploadButton());
		leftHalf_c.add(addUpdateDeleteButtonsC("Contestant"));
		
		// Create a seperator
		leftHalf_c.setBorder(BorderFactory.createEmptyBorder(
										                GAP/2, //top
										                0,     //left
										                GAP/2, //bottom
										                0));   //right
	    leftHalf_c.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
	    leftHalf_c.setPreferredSize(new Dimension(492,580));

	    JPanel rightHalf_c = new JPanel();
	    rightHalf_c.setLayout(new BoxLayout(rightHalf_c, BoxLayout.PAGE_AXIS));
	    rightHalf_c.setOpaque(false);
	    rightHalf_c.add(contestantPicFrame);
	    rightHalf_c.add(Box.createRigidArea(new Dimension(0,GAP/2)));
	    rightHalf_c.add(textFields_c.createRecordDisplay(), BorderLayout.NORTH);
	    rightHalf_c.setPreferredSize(new Dimension(350,530));
	    
	    cPanel.setOpaque(false);
	    cPanel.add(leftHalf_c);
	    cPanel.add(Box.createRigidArea(new Dimension(GAP*2,0)));
	    cPanel.add(rightHalf_c, BorderLayout.CENTER);
	    
		// Assemble the text fields with the background as a large panel
		SpringLayout cLayout = new SpringLayout();
		JPanel contestantPanel = new JPanel(cLayout);
	    this.setLayout(cLayout);
		
	    getContentPane().add(mainMenuButton());
		getContentPane().add(cPanel);
		getContentPane().add(contestantBg);

	    cLayout.putConstraint(SpringLayout.WEST, contestantBg, 0, SpringLayout.WEST, getContentPane());
	    cLayout.putConstraint(SpringLayout.NORTH, contestantBg, 0, SpringLayout.NORTH, getContentPane());

	    cLayout.putConstraint(SpringLayout.WEST, mMenuBtnPanel, 0, SpringLayout.WEST, getContentPane());
	    cLayout.putConstraint(SpringLayout.NORTH, mMenuBtnPanel, 0, SpringLayout.NORTH, getContentPane());
	    
	    cLayout.putConstraint(SpringLayout.WEST, cPanel, GAP*2, SpringLayout.WEST, getContentPane());
	    cLayout.putConstraint(SpringLayout.NORTH, cPanel, 150, SpringLayout.NORTH, getContentPane());

		return contestantPanel;
	}	
	/**
	 * The Golden Ruins Theme
	 */
	protected void goldenRuinsTheme() {		
		//Switch the images
		playerBg.setIcon(playerGBg);
		contestantBg.setIcon(contestantGBg);
		standingBg.setIcon(standingGBg);
		bqBg.setIcon(bqGBg);
		textFields_p.setGameFontP(gFont, Color.YELLOW);
		textFields_c.setGameFontC(gFont, Color.YELLOW);
		
		themeMaker.setIcon(goldBackground);
//		mainMenuBtn.setIcon(mainMenuImgG);

		playerBtnImg = playersGoldImg;
		contestantPicFrame.setIcon(blankGFrame);
		playersBtn.setIcon(playersGoldImg);
			
		createNewGameBtn.setFont(gFont);
		createNewGameBtn.setForeground(Color.YELLOW);
		playersBtn.setFont(gFont);
		playersBtn.setForeground(Color.YELLOW);		
		contestantsBtn.setFont(gFont);
		contestantsBtn.setForeground(Color.YELLOW);
		bonusQBtn.setFont(gFont);
		bonusQBtn.setForeground(Color.YELLOW);
		standingsBtn.setFont(gFont);
		standingsBtn.setForeground(Color.YELLOW);
		themeSelectBtn.setFont(gFont);
		themeSelectBtn.setForeground(Color.YELLOW);
	}
	/**
	 * The Jungle Theme
	 */
	protected void jungleTheme() {		
		playersJungleImg = createImageIcon("images/bbJ.png");
		jungleBackground = createImageIcon("images/jungle1.jpg");
		playerJBg = createImageIcon("images/jungle10.jpg");
		contestantJBg = createImageIcon("images/tiger-jungle.jpg");
		blankJFrame = createImageIcon("images/uploadPicFrame_jungleFrame.png");
		standingJBg = createImageIcon("images/standingsJungle.jpg");
		bqJBg = createImageIcon("images/bqJungle.jpg");
		
		//Switch the images
		contestantPicFrame.setIcon(blankJFrame);
		playerBtnImg = playersJungleImg;
		playersBtn.setIcon(playersJungleImg);
		themeMaker.setIcon(jungleBackground);

		playerBg.setIcon(playerJBg);
		contestantBg.setIcon(contestantJBg);
		standingBg.setIcon(standingJBg);
		bqBg.setIcon(bqJBg);
		
		textFields_p.setGameFontP(jFont, Color.WHITE);
		textFields_c.setGameFontC(jFont, Color.WHITE);
		
		createNewGameBtn.setFont(jFont);
		createNewGameBtn.setForeground(Color.WHITE);
		playersBtn.setFont(jFont);
		playersBtn.setForeground(Color.WHITE);		
		contestantsBtn.setFont(jFont);
		contestantsBtn.setForeground(Color.WHITE);
		bonusQBtn.setFont(jFont);
		bonusQBtn.setForeground(Color.WHITE);
		standingsBtn.setFont(jFont);
		standingsBtn.setForeground(Color.WHITE);
		themeSelectBtn.setFont(jFont);
		themeSelectBtn.setForeground(Color.WHITE);	
	}
	/**
	 * Creates an image icon of a requested image, prints a error message is request path not found
	 * @param path to the requested file
	 * @return the requested file
	 */
	public ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = SurvivorPoolAdminGUI.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}		
	}
	/**
	* Test if a string contains only letters
	*
	* @param input string to test
	* @return boolean true if contains no invalid characters
	*/
	public Boolean checkValidChars(String input) {
	Boolean validChars = false;

	// check if characters are valid
	for (int i = 0; i < input.length(); i++) {

	// store character one at a time
	char character = input.charAt(i);

	if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
	validChars = true;
	}
	else {
		validChars = false;
		break;
	}

	}
	return validChars;
	}

	/**
	*
	* @param first
	* @param last
	* @return
	*/
	public Contestant findContestant(String first, String last){
	Contestant tempCont = null;
	for (int i = 0; i < contestants.length; i++){
	if ((contestants[i].getFirst().equals(first) && (contestants[i].getLast().equals(last))))
	{
	tempCont = contestants[i];
	}

	}
	return tempCont;
	}
	
	
	
	/**
	 * Handles all Button Actions 
	 * Each case compares the string cast as an ActionCommand
	 */
	public void actionPerformed(ActionEvent e) {	
		/**  Add Player Handler  **/
		if(e.getActionCommand().equals("+P")) {
			String first=textFields_p.getFirstP();
			String last=textFields_p.getLastP();
			int firstLen=first.length(),lastLen=last.length();
			if(firstLen<1 || firstLen>20){
				JOptionPane.showMessageDialog(this,"The player's first Name must be between 1 and 20 characters");
				System.out.println(first+"first");
			}
			else if(lastLen<1 || lastLen>20){
				JOptionPane.showMessageDialog(this,"The player's last name must be between 1 and 20 characters");
			}
			else{	
			String IDchars=""+first.charAt(0), ID="";
			int IDnum=1;
			boolean isUnique=false;
			if(last.length()>=6)
				IDchars=IDchars+last.substring(0,6);
			else
				IDchars=IDchars+last;
			ID=IDchars+IDnum;
			while(!isUnique){
				isUnique=true;
				if(players!=null){
				for(int i=0;i<players.length && isUnique ;i++){
					if(players[i].getID().equals(ID)){
						isUnique=false;
						break;
					}	
				}
				if(isUnique==false){
					IDnum++;
					ID=IDchars+IDnum;
				}
				}
			}
			this.addPlayer(new Player(first,last,ID));
			this.writePlayers("players.txt");
			
			
		}
		}
		/**  Update Player Handler  **/
		if(e.getActionCommand().equals("updateP")) {
			
		}
		/**  Delete Player Handler  **/
		if(e.getActionCommand().equals("deleteP")) {
			
		}
		/**  Add Contestant Handler **/
		if(e.getActionCommand().equals("+C")) {
			String inputFirst = textFields_c.getFirstC();
			String inputLast = textFields_c.getLastC();
			String inputTribe = textFields_c.getTribe();


			if ((inputFirst.length() < 1) || (inputFirst.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputFirst)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must only contain letters");
			}

			else if ((inputLast.length() < 1) || (inputLast.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputLast)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must only contain letters");
			}

			else if ((inputTribe.length() < 1) || (inputTribe.length() >30)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must be between 1 and 30 characters long");
			}

			else if (!checkValidChars(inputTribe)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must only contain letters");
			}


			//Contestant newContestant = new Contestant(inputFirst, inputLast, inputID, inputTribe, inputPic);
			//contestants[contCount] = newContestant;
			//contCount++;
		}
		/**  Update Contestant Handler  **/
		if(e.getActionCommand().equals("updateC")) {
			String inputFirst = textFields_c.getFirstC();
			String inputLast = textFields_c.getLastC();
			String inputTribe = textFields_c.getTribe();


			if ((inputFirst.length() < 1) || (inputFirst.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputFirst)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must only contain letters");
			}

			else if ((inputLast.length() < 1) || (inputLast.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputLast)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must only contain letters");
			}

			else if ((inputTribe.length() < 1) || (inputTribe.length() >30)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must be between 1 and 30 characters long");
			}

			else if (!checkValidChars(inputTribe)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must only contain letters");
			}
		}
		/**  Delete Contestant Handler  **/
		if(e.getActionCommand().equals("deleteC")) {
			String inputFirst = textFields_c.getFirstC();
			String inputLast = textFields_c.getLastC();
			String inputTribe = textFields_c.getTribe();


			if ((inputFirst.length() < 1) || (inputFirst.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputFirst)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid first name, it must only contain letters");
			}

			else if ((inputLast.length() < 1) || (inputLast.length() >20)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must be between 1 and 20 characters long");
			}
			else if (!checkValidChars(inputLast)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid last name, it must only contain letters");
			}

			else if ((inputTribe.length() < 1) || (inputTribe.length() >30)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must be between 1 and 30 characters long");
			}

			else if (!checkValidChars(inputTribe)){
			JOptionPane.showMessageDialog(this, "Sorry that's not a valid tribe name, it must only contain letters");
			}
		}
		/**  Reset Fields Handler  **/
		if(e.getActionCommand().equals("reset")) {
			String firstFieldC = textFields_c.getFirstC();
			String lastFieldC = textFields_c.getLastC();
			String tribeField = textFields_c.getTribe();

			String firstFieldP = textFields_p.getTribe();
			String lastFieldP = textFields_p.getTribe();

			if(firstFieldP != "" || lastFieldP != " ") {
			textFields_p.setFirstP("");
			textFields_p.setLastP("");
			}
			if(firstFieldC != "" || lastFieldC != " ") {
			textFields_c.setFirstC("");
			textFields_c.setLastC("");
			textFields_c.setTribe("");
			}
		}
		/**  Quit Button Handler **/
		if(e.getActionCommand().equals("q")) {
			quitBtn.setBorder(BorderFactory.createEmptyBorder());
			System.exit(0);
		}
		/**  Create New Game Button Handler **/
		else if(e.getActionCommand().equals("new")) {
			
		}
		/**  Main Menu Button Handler **/
		else if(e.getActionCommand().equals("main")) {			
			getContentPane().removeAll();		
			getContentPane().add(mainScreen());	
			
			repaint();
			validate();		
			}
		/**  Players List Button Handler **/
		else if(e.getActionCommand().equals("players")) {
			getContentPane().removeAll();

			getContentPane().add(quitButton());			
			getContentPane().add(playersPanel());

			repaint();
			validate();								
		}
		/**  Contestants List Button Handler **/
		else if(e.getActionCommand().equals("contestants")) {
			getContentPane().removeAll();

			getContentPane().add(quitButton());
			getContentPane().add(contestantPanel());

			repaint();
			validate();								
		}
		/**  Standings List Button Handler **/
		else if(e.getActionCommand().equals("standings")) {
			getContentPane().removeAll();

			getContentPane().add(quitButton());
			getContentPane().add(standingsPanel());
			
			repaint();
			validate();		
		}
		/**  Bonus Question Admin Button Handler **/
		else if(e.getActionCommand().equals("bonus")) {
			getContentPane().removeAll();

			getContentPane().add(quitButton());
			getContentPane().add(bqPanel());
			
			repaint();
			validate();	
		}
		/**  Theme Selector Button Handler **/
		else if(e.getActionCommand().equals("theme")) {		
			// Setst the jungle theme
			if(themeMaker.getIcon().equals(goldBackground)) {
				jungleTheme();
			}
			// Sets the Golden Ruins Theme
			else 
			{ 
				goldenRuinsTheme();
			}
//			if(contestantBg.getIcon().equals(contestantGBg))
//				contestantBg.setIcon(contestantJBg);
//			else
//				contestantBg.setIcon(contestantGBg);

		}
		/**  Start the Game **/
		else if(e.getActionCommand().equals("settings")) {
			GameSettings settings = new GameSettings();
			settings.gameSettingsWindow();
			// If Game Start has confirmed ********  TODO ****************
			//Disable edit and delete Player/Contestant Forms
		}
		/**  Start a new Game **/
		else if(e.getActionCommand().equals("new")) {
			
		}
    	/**  Upload Button Handler  **/
    	else if(e.getActionCommand().equals("upload")) {
    		JFileChooser fileChooser = new JFileChooser();
    		int returnVal = fileChooser.showOpenDialog(this);
    		if (returnVal == JFileChooser.APPROVE_OPTION){
    		File contestantPhoto = fileChooser.getSelectedFile();
    		}
    	}
    	
	}
		
}

	
