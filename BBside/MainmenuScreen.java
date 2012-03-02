import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

/**
 * MainmenuScreen class allows user to navigate through Survival Pool program
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 */
public class MainmenuScreen extends MainScreen implements FieldChangeListener {
	// Attributes
	private MyButtonField standingsButton;
	private MyButtonField pickContestantButton;
	private MyButtonField pickWinnerButton;
	private MyButtonField bonusQuestionButton;
	private MyButtonField exitButton;

	/**
	 * Constructor for main menu screen
	 */
	public MainmenuScreen() {
		// add text labels to screen
		add(new LabelField("Week: 14", Field.FIELD_HCENTER));
		add(new LabelField("Your Score: 9999" + " (1st " + "place)",
				Field.FIELD_HCENTER));
		add(new LabelField("Current Pick: Jim Bob", Field.FIELD_HCENTER));
		add(new LabelField("Winner Pick: Chuck Norris", Field.FIELD_HCENTER));

		// set layout for buttons
		add(new SeparatorField());
		VerticalFieldManager buttonManager = new VerticalFieldManager(
				FIELD_HCENTER);
		buttonManager.setMargin(15, 15, 15, 15);

		// create buttons
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

		// add buttons to screen
		buttonManager.add(pickContestantButton);
		buttonManager.add(pickWinnerButton);
		buttonManager.add(standingsButton);
		buttonManager.add(bonusQuestionButton);
		buttonManager.add(exitButton);
		add(buttonManager);
	}

	/**
	 * Method invoked by a field when a property changes on MainMenuScreen
	 * 
	 * @param field
	 *            The field that changed
	 * @param context
	 *            Information specifying origin of the change
	 */
	public void fieldChanged(Field field, int context) {
		// exit program
		if (field == exitButton) {
			System.exit(0);
		}
		// open PickWinnerScreen
		if (field == pickWinnerButton) {
			PickWinnerScreen pwScreen = new PickWinnerScreen();
			UiApplication.getUiApplication().pushScreen(pwScreen);
		}
		// open screen to display standings
		if (field == standingsButton) {
			StandingsScreen sScreen = new StandingsScreen();
			UiApplication.getUiApplication().pushScreen(sScreen);
		}
		// open screen to display bonus questions
		if (field == bonusQuestionButton) {
			BonusQuestionScreen bqScreen = new BonusQuestionScreen();
			UiApplication.getUiApplication().pushScreen(bqScreen);
		}
		// open screen to pick contestants
		if (field == pickContestantButton) {
			PickContestantScreen pcScreen = new PickContestantScreen();
			UiApplication.getUiApplication().pushScreen(pcScreen);
		}

	}
}
