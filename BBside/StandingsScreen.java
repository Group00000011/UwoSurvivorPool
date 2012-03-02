import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.SimpleList;
import net.rim.device.api.ui.container.*;

/**
 * StandingsScreen class displays the standings of all the players
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 */
public class StandingsScreen extends MainScreen implements FieldChangeListener {
	// Attributes
	private ButtonField backButton;
	private ButtonField exitButton;
	private BitmapField logoBitmapField;
	private String userName[] = { "mgrabar", "rcool", "bgates", "sjobs",
			"bjoe", "asskicker", "cnoris", "babygurl" };
	private int userScore[] = { 1000, 900, 800, 700, 600, 500, 400, 300, 200 };

	/**
	 * Constructor for Standings screen
	 */
	public StandingsScreen() {
		super(Manager.NO_VERTICAL_SCROLL);
		// display image
		Bitmap logoBitmap = Bitmap.getBitmapResource("Standings.png");
		logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
		add(logoBitmapField);

		Manager mainManager = getMainManager();

		SimpleList listField = new SimpleList(mainManager);
		// create list of players
		for (int i = 0; i < userName.length; i++) {
			listField.add(i + 1 + " | " + userName[i] + ":" + userScore[i]);
		}
		// create back and exit buttons
		backButton = new ButtonField("Back");
		exitButton = new ButtonField("Quit");
		backButton.setChangeListener(this);
		exitButton.setChangeListener(this);
		// add buttons and set layout of buttons
		HorizontalFieldManager buttonManager = new HorizontalFieldManager(
				Field.FIELD_RIGHT | Manager.VERTICAL_SCROLL);
		buttonManager.add(backButton);
		buttonManager.add(exitButton);
		add(buttonManager);
	}

	/**
	 * Method invoked by a field when a property changes on StandingsScreen
	 * 
	 * @param field
	 *            The field that changed
	 * @param context
	 *            Information specifying origin of the change
	 */
	public void fieldChanged(Field field, int context) {
		// go to previous screen
		if (field == backButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
		// exit application
		if (field == exitButton) {
			System.exit(0);
		}
	}
}
