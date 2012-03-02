import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

/**
 * BonusQuestionScreen allows users to see and answer bonus questions
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 * 
 */
public class BonusQuestionScreen extends MainScreen implements
		FieldChangeListener {
	// Attributes
	private BitmapField logoBitmapField;
	private ButtonField backButton;
	private ButtonField exitButton;
	private ButtonField answerButton;
	private String bonusQuestion;
	private EditField answerField;

	/**
	 * Constructor for bonus questions
	 */
	public BonusQuestionScreen() {
		// super();
		// set logo
		Bitmap logoBitmap = Bitmap.getBitmapResource("BQ.png");
		logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
		add(logoBitmapField);

		add(new SeparatorField());
		// create buttons
		backButton = new ButtonField("Back");
		exitButton = new ButtonField("Quit");
		answerButton = new ButtonField("Answer");
		backButton.setChangeListener(this);
		exitButton.setChangeListener(this);
		answerButton.setChangeListener(this);
		// create font
		Font myFont = Font.getDefault().derive(Font.BOLD);
		// create bonus questions and set them
		bonusQuestion = "This is a bonus question test blah blah blah blah blah blah blah.";
		LabelField questionLabelField = new LabelField("Question:");
		questionLabelField.setFont(myFont);
		add(questionLabelField);
		add(new LabelField(bonusQuestion));
		add(new LabelField(""));
		// create answer field and add to screen
		answerField = new EditField("", "", 200, EditField.NO_LEARNING
				| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
		LabelField answerLabelField = new LabelField("Answer:");
		answerLabelField.setFont(myFont);
		add(answerLabelField);
		add(answerField);

		add(new SeparatorField());
		// add buttons to screen
		HorizontalFieldManager buttonManager = new HorizontalFieldManager(
				Field.FIELD_RIGHT);
		buttonManager.add(answerButton);
		buttonManager.add(backButton);
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
		// go back
		if (field == backButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
		// exit program
		if (field == exitButton) {
			System.exit(0);
		}
		// answer question
		if (field == answerButton) {
			UiApplication.getUiApplication().popScreen(
					UiApplication.getUiApplication().getActiveScreen());
		}
	}
}
