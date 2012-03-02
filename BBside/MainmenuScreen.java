import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

public class MainmenuScreen extends MainScreen implements FieldChangeListener {
    private MyButtonField standingsButton;
    private MyButtonField pickContestantButton;
    private MyButtonField pickWinnerButton;
    private MyButtonField bonusQuestionButton;
    private MyButtonField exitButton;
 

    public MainmenuScreen() {
    	   
    	add(new LabelField("Week: 14", Field.FIELD_HCENTER));
    	add(new LabelField("Your Score: 9999" + " (1st " + "place)", Field.FIELD_HCENTER));
    	add(new LabelField("Current Pick: Jim Bob", Field.FIELD_HCENTER));
    	add(new LabelField("Winner Pick: Chuck Norris", Field.FIELD_HCENTER));

        add(new SeparatorField());

        VerticalFieldManager buttonManager = new VerticalFieldManager(FIELD_HCENTER);
        buttonManager.setMargin(15,15,15,15);
        
        pickContestantButton = new MyButtonField("Pick Contestant", 200);
        pickContestantButton.setChangeListener(this);
        standingsButton = new MyButtonField("Standings", 200);
        standingsButton.setChangeListener(this);
        pickWinnerButton = new MyButtonField("Pick Winner", 200);
        pickWinnerButton.setChangeListener(this);
        bonusQuestionButton = new MyButtonField("Bonus Question", 200);
        bonusQuestionButton.setChangeListener(this);
        exitButton = new MyButtonField("Quit", 200);
        exitButton.setChangeListener(this);
    
        buttonManager.add(pickContestantButton);
        buttonManager.add(pickWinnerButton);
        buttonManager.add(standingsButton);
        buttonManager.add(bonusQuestionButton);
        buttonManager.add(exitButton);
        add(buttonManager);
   }


       public void fieldChanged(Field field, int context) {
    	   	  //if quit button is pressed exit
              if (field == exitButton) {
            	  System.exit(0);
              }
              if (field == pickWinnerButton) {
            	  PickWinnerScreen pwScreen = new PickWinnerScreen();
                  UiApplication.getUiApplication().pushScreen(pwScreen);
              }
              if (field == standingsButton) {
            	  StandingsScreen sScreen = new StandingsScreen();
                  UiApplication.getUiApplication().pushScreen(sScreen);
              }
              if (field == bonusQuestionButton) {
            	  BonusQuestionScreen bqScreen = new BonusQuestionScreen();
                  UiApplication.getUiApplication().pushScreen(bqScreen);
              }
              if (field == pickContestantButton) {
            	  PickContestantScreen pcScreen = new PickContestantScreen();
                  UiApplication.getUiApplication().pushScreen(pcScreen);
              }
              
       }
} 

