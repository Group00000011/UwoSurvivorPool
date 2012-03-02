import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.RichList;
import net.rim.device.api.ui.container.*;

/**
 * PickWinnerScreen creates a screen that allows the player to pick who they
 * think will win
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 */
public class PickWinnerScreen extends MainScreen implements FieldChangeListener {
	// Attributes
	private ButtonField backButton;
	private ButtonField exitButton;
	private ButtonField pickButton;
	private EditField pickField;
	private BitmapField logoBitmapField;

	private String contestantName[] = { "Bill Black", "Joe Cool", "Jim Bob",
			"Mary Anne", "Anne Smith" };
	private String tribeName[] = { "Cats", "Dogs", "Dogs", "Dogs", "Cats",
			"Cats", "Cats" };

	/**
	 * Constructor for PickWinnerScreen
	 */
	public PickWinnerScreen() {
		// create screen
		super(NO_VERTICAL_SCROLL);
		// create and set logo
		Bitmap logoBitmap = Bitmap.getBitmapResource("PW.png");
		logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
		add(logoBitmapField);
		// create font and list
		Manager mainManager = getMainManager();
		Font myFont = Font.getDefault().derive(Font.BOLD);
		RichList list = new RichList(mainManager, true, 2, 1);
		// add contestants to list
		for (int i = 0; i < contestantName.length; i++) {

			// String imageFileName = contestantName[i] + ".png";
			String imageFileName = "Standings.png";
			Bitmap bitmap = Bitmap.getBitmapResource(imageFileName);
			list.add(new Object[] { bitmap, "Name: " + contestantName[i],
					"Tribe: " + tribeName[i], "" });
		}
		// create buttons
		backButton = new ButtonField("Back");
		exitButton = new ButtonField("Quit");
		pickButton = new ButtonField("Pick");
		backButton.setChangeListener(this);
		exitButton.setChangeListener(this);
		pickButton.setChangeListener(this);
		// create field for entering choice
		pickField = new EditField("", "", 200, EditField.NO_LEARNING
				| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
		LabelField pickLabelField = new LabelField("Enter Picks Name:");
		pickLabelField.setFont(myFont);
		add(pickLabelField);
		add(pickField);

		add(new SeparatorField());

		HorizontalFieldManager buttonManager = new HorizontalFieldManager(
				Field.FIELD_RIGHT);
		// add buttons to screen
		buttonManager.add(pickButton);
		buttonManager.add(backButton);
		buttonManager.add(exitButton);
		add(buttonManager);

	}

	/**
	 * Method invoked by a field when a property changes on PickWinnersScreen
	 * 
	 * @param field
	 *            The field that changed
	 * @param context
	 *            Information specifying origin of the change
	 */
	public void fieldChanged(Field field, int context) {
		// go back
		if (field == backButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
		// exit
		if (field == exitButton) {
			System.exit(0);
		}
		// make pick
		if (field == pickButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
	}
}
