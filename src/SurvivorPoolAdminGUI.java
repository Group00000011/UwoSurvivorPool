/**
 * The administrative interface 
 * The look & feel 
 * @author hrivera
 * V 1.0 02/18/12
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SurvivorPoolAdminGUI extends JFrame implements ActionListener {
	/****************************** Attributes ***************************************/
	// The default measurements for the main window
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
    final static int GAP = 20;
	
	// Images
	private ImageIcon survivorLogoImg = createImageIcon("images/survivorLogo.png");
	private ImageIcon title, quitImg, mainMenuBtnImg;
	private ImageIcon goldBackground = createImageIcon("images/ruins.jpg"), jungleBackground;
	private ImageIcon newGame, playerBtnImg, playersJungleImg, playersGoldImg = createImageIcon("images/bbG.png"), contestantImg, stadingsImg, bonusQImg, themeSelectImg;
	private ImageIcon playerJBg, playerGBg, contestantJBg, contestantGBg, blankGFrame, blankJFrame;
	
	// Buttons
	private JButton quitBtn, mainMenuBtn, createNewGameBtn, playersBtn, contestantsBtn, standingsBtn, bonusQBtn, themeSelectBtn;		

	// JLabels
	private JLabel themeMaker = new JLabel(goldBackground), playerBg, contestantBg, titleBanner, contestantPicFrame;
	
	// JPanels
	private JPanel mainPanel, quitPanel, mMenuBtnPanel, titlePanel, mainButtonsPanel, pPanel, playerPanel, cPanel, contestantPanel;
	
	private TextInputFields textFields_p, textFields_c;
	
	private Font gFont, jFont;

	/******************************** Constructor *************************************/
	public SurvivorPoolAdminGUI() {	
		textFields_p = new TextInputFields();
		textFields_c = new TextInputFields();
		
		// Font for the Golden Ruin Theme
		gFont = new Font("Pescadero",Font.PLAIN,18);
		// The jungle theme font
		jFont = new Font("Viner Hand ITC",Font.PLAIN,18);

		SpringLayout guiLayout = new SpringLayout();	
        this.setLayout(guiLayout);
        
        this.setJMenuBar(menuBar());

        getContentPane().add(quitButton());
        getContentPane().add(mainScreen());	

    	playerGBg = createImageIcon("images/playerGoldenBg.jpg");
		playerBg = new JLabel(playerGBg);

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
	}// End of AdminGUI Constructor
	
	/******************************  Methods  *********************************/
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
	/**
	 * Players Edit, Add & Store Panel/Screen
	 */
	protected JComponent playersPanel() {
		pPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				
		JPanel leftHalf_p = new JPanel();
		leftHalf_p.setLayout(new BoxLayout(leftHalf_p, BoxLayout.PAGE_AXIS));	
		leftHalf_p.add(textFields_p.createNameFields());
		leftHalf_p.add(textFields_p.addUpdateDeleteButtons("Player"));
		leftHalf_p.setOpaque(false);

		// Create a seperator
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
		playerPanel = new JPanel(pLayout);
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
		leftHalf_c.add(textFields_c.createNameFields());
	    leftHalf_c.add(textFields_c.createTribeField());
	    leftHalf_c.add(textFields_c.uploadButton());
		leftHalf_c.add(textFields_c.addUpdateDeleteButtons("Contestant"));
		
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
		contestantPanel = new JPanel(cLayout);
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
		playerGBg = createImageIcon("images/playerGoldenBg.jpg");
		playerBg = new JLabel(playerGBg);
		
		contestantGBg = createImageIcon("images/contestantGoldenBg.jpg");
		blankGFrame = createImageIcon("images/uploadPicFrame_goldFrame.png");
		contestantBg = new JLabel(contestantGBg);
		contestantPicFrame = new JLabel(blankGFrame);
		
		//Switch the images
		playerBg.setIcon(playerGBg);
		contestantBg.setIcon(contestantGBg);
		textFields_p.setGameFont(gFont, Color.YELLOW);
		textFields_c.setGameFont(gFont, Color.YELLOW);
		
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
		
		//Switch the images
		contestantPicFrame.setIcon(blankJFrame);
		playerBtnImg = playersJungleImg;
		playersBtn.setIcon(playersJungleImg);
		themeMaker.setIcon(jungleBackground);

		playerBg.setIcon(playerJBg);
		contestantBg.setIcon(contestantJBg);
		
		textFields_p.setGameFont(jFont, Color.WHITE);
		textFields_c.setGameFont(jFont, Color.WHITE);
		
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
		java.net.URL imgURL = AdminGUI.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}		
	}
	/**
	 * Handles all Button Actions 
	 * Each case compares the string cast as an ActionCommand
	 */
	public void actionPerformed(ActionEvent e) {		
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
			
		}
		/**  Bonus Question Admin Button Handler **/
		else if(e.getActionCommand().equals("bonus")) {
			
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
	}
		
}
	
