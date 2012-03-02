import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.*;
import net.rim.device.api.ui.container.*;

/**
 * PickContestantsScreen allows users to pick who will be eliminated in the
 * current round
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 */
public class PickContestantScreen extends MainScreen implements
		FieldChangeListener {
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
	 * Constructor for PickContestants Screen
	 */
	public PickContestantScreen() {
		// create screen
		super(Manager.NO_VERTICAL_SCROLL);
		// add logo
		Bitmap logoBitmap = Bitmap.getBitmapResource("PC.png");
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
		// add text field where user choose contestant
		pickField = new EditField("", "", 200, EditField.NO_LEARNING
				| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
		LabelField pickLabelField = new LabelField("Enter Picks Name:");
		pickLabelField.setFont(myFont);
		add(pickLabelField);
		add(pickField);

		add(new SeparatorField());
		// add buttons
		HorizontalFieldManager buttonManager = new HorizontalFieldManager(
				Field.FIELD_RIGHT);
		buttonManager.add(pickButton);
		buttonManager.add(backButton);
		buttonManager.add(exitButton);
		add(buttonManager);

	}

	/**
	 * Method invoked by a field when a property changes on PickContestantScreen
	 * 
	 * @param field
	 *            The field that changed
	 * @param context
	 *            Information specifying origin of the change
	 */
	public void fieldChanged(Field field, int context) {
		// Go back
		if (field == backButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
		// Exit program
		if (field == exitButton) {
			System.exit(0);
		}
		// Pick Contestant
		if (field == pickButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
	}

}
