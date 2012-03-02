/**
 * The administrative interface 
 * The look & feel 
 * @author hrivera
 * V 1.0 02/18/12
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class AdminGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/****************************** Attributes ***************************************/
	// The default measurements for the main window
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	
	// Images
	private static ImageIcon survivorLogoImg = createImageIcon("images/survivorLogo.png");
	private static ImageIcon title, quit;
	private static ImageIcon goldBackground, jungleBackground;
	private static ImageIcon newGame, playersJungleImg, playersGoldImg, contestantImg, stadingsImg, bonusQImg, themeSelectImg;
	private static ImageIcon cw1Img = createImageIcon("images/1.png");	
	private static ImageIcon cw2Img = createImageIcon("images/2.png");	
	private static ImageIcon cw3Img = createImageIcon("images/3.png");	
	private static ImageIcon cw4Img = createImageIcon("images/4.png");	
	private static ImageIcon cw5Img = createImageIcon("images/5.png");	
	private static ImageIcon cw6Img = createImageIcon("images/6.png");	
	private static ImageIcon cw7Img = createImageIcon("images/7.png");	
	private static ImageIcon cw8Img = createImageIcon("images/8.png");	
	private static ImageIcon cw9Img = createImageIcon("images/9.png");	
	private static ImageIcon cw10Img = createImageIcon("images/10.png");	
	private static ImageIcon cw11Img = createImageIcon("images/11.png");	
	private static ImageIcon cw12Img = createImageIcon("images/12.png");	
	private static ImageIcon cw13Img = createImageIcon("images/13.png");	

	
	// Components
		// Buttons
		private static JButton quitBtn, createNewGameBtn, playersBtn, contestantsBtn, standingsBtn, bonusQBtn, themeSelectBtn;
		

		// JLabels
		private static JLabel themeMaker, titleBanner, goldBg;

		// Current Week image array
		private ImageIcon[] currWkArrayIndex = {cw1Img,cw2Img,cw3Img,cw4Img,cw5Img,cw6Img,cw7Img,cw8Img,cw9Img,cw10Img,cw11Img,cw12Img,cw13Img,};
		private JLabel currWkNumImg = new JLabel(currWkArrayIndex[0]);
	
		// Text Fields and areas
	
		// Misc 
	/******************************** Constructor *************************************/
	public AdminGUI() {
//		JTextField title = new JTextField("UWOSurvivorPoolAdmin");
		
		// Create an instance of the layout manager
		SpringLayout layout = new SpringLayout(); 
		
		// Set up buttons
			// load the images from file & convert to JComponent
			// Set the Action Listeners
			// Add the Action Listeners
			// Add to the Frame				
		// Quit Button
		quit = createImageIcon("images/Quit-icon.png");
		quitBtn = new JButton(quit);
        // Set the button layout
		quitBtn.setOpaque(false);
		quitBtn.setFocusPainted(false);
		quitBtn.setBorderPainted(false);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		// Set Action Commands
		quitBtn.setMnemonic(KeyEvent.VK_Q);
		quitBtn.setActionCommand("q");
        quitBtn.addActionListener(this);
       // getContentPane().add(quitBtn);

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
        createNewGameBtn.setActionCommand("new");
        createNewGameBtn.addActionListener(this);
        getContentPane().add(createNewGameBtn);
        
        // Players List Button - Set Gold image as part of default theme
        playersGoldImg = createImageIcon("images/bbG.png");
        playersBtn = new JButton("Players",playersGoldImg);
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
        getContentPane().add(playersBtn);
       
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
        getContentPane().add(contestantsBtn);
        
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
        getContentPane().add(standingsBtn);
        
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
        getContentPane().add(bonusQBtn);
        
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
        getContentPane().add(themeSelectBtn);
        
        // Set up the title banner
        title = createImageIcon("images/title.png");
        titleBanner = new JLabel(title);
        titleBanner.setToolTipText("By Hazel R, Manor F, Jeff W, Liam C, Delerina H, Martin G");
        getContentPane().add(titleBanner);
       
        goldBackground = createImageIcon("images/ruins.jpg");
        goldBg = new JLabel(goldBackground);
        themeMaker = goldBg; // Sets the default as Golden Ruins
        getContentPane().add(themeMaker);
        
		// Set up the frame
        this.getContentPane().setLayout(layout);
        // The default background images is set before the theme selector button is selected
        layout.putConstraint(SpringLayout.WEST, themeMaker, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, themeMaker, 0, SpringLayout.NORTH, getContentPane());
          
        layout.putConstraint(SpringLayout.WEST, titleBanner, 50, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, titleBanner, 30, SpringLayout.NORTH, getContentPane());
           
        layout.putConstraint(SpringLayout.WEST, playersBtn, 40, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, playersBtn, 160, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, createNewGameBtn, 360, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, createNewGameBtn, 155, SpringLayout.NORTH, getContentPane());        
 
        layout.putConstraint(SpringLayout.WEST, contestantsBtn, 675, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, contestantsBtn, 160, SpringLayout.NORTH, getContentPane());
       
        layout.putConstraint(SpringLayout.EAST, standingsBtn, -675, SpringLayout.EAST, getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, standingsBtn, -50, SpringLayout.SOUTH, getContentPane());       
       
        layout.putConstraint(SpringLayout.EAST, bonusQBtn, -355, SpringLayout.EAST, getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, bonusQBtn, -50, SpringLayout.SOUTH, getContentPane());       

        layout.putConstraint(SpringLayout.EAST, themeSelectBtn, -35, SpringLayout.EAST, getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, themeSelectBtn, -50, SpringLayout.SOUTH, getContentPane());  
  
        layout.putConstraint(SpringLayout.WEST, quitBtn, 40, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, quitBtn, 20, SpringLayout.NORTH, getContentPane());

        

        // Set up methods for the frame
        this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("UWOSurvivorPoolAdmin");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}// End of AdminGUI
	
	/*********************************************************************************/
	/**
	 * Creates an image icon of downloaded images
	 * @returns the imageIcon if found; otherwise, returns an error message  
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = AdminGUI.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}		
	}
	/**
	 * 
	 */
//	private void f() {
//		this.add(getContentPane().add(goldBg));
//	}
//	
//	/**
//	 * 
//	 */
//	private void df() {
//		
//	}
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
		///////////////////////////////////////////////	
		}
		/**  Opens Players List and changes area **/
		else if(e.getActionCommand().equals("players")) {
			playersBtn.setIconTextGap(100);
		}
		/**  Theme Selector Button Handler **/
		else if(e.getActionCommand().equals("theme")) {
			// Font for the Golden Ruin Theme
			Font gFont = new Font("Pescadero",Font.PLAIN,18);
			// Sets the jungle theme
			Font jFont = new Font("Viner Hand ITC",Font.CENTER_BASELINE,18);
			playersJungleImg = createImageIcon("images/bbJ.png");
			jungleBackground = createImageIcon("images/jungle1.jpg");
			
			if(themeMaker.getIcon().equals(goldBackground)) {
				themeMaker.setIcon(jungleBackground);
				playersBtn.setIcon(playersJungleImg);
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

				// Still need to attach the font to something in this window
				}
			// Sets the Golden Ruins Theme
			
			else 	
			{
				themeMaker.setIcon(goldBackground);
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
		} // End of Theme Selector button handler
		/** New Game Button Handler **/
		else if(e.getActionCommand().equals("new")) {
	//		JOptionPane.showInputDialog(this, "Create a new Survivor Pool", )
		}
	}// End of ActionPreformed buttons method	

} // End of class
