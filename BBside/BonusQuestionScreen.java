
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


public class BonusQuestionScreen extends MainScreen implements FieldChangeListener {
	   private BitmapField logoBitmapField;
       private ButtonField backButton;
       private ButtonField exitButton;
       private ButtonField answerButton;
	   private String bonusQuestion;
	   private EditField answerField;

       public BonusQuestionScreen() {
              //super();
              
              Bitmap logoBitmap = Bitmap.getBitmapResource("BQ.png");
              logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
              add(logoBitmapField);
              
              add(new SeparatorField());
              
              backButton = new ButtonField("Back");
              exitButton = new ButtonField("Quit");
              answerButton = new ButtonField("Answer");
              backButton.setChangeListener(this);
              exitButton.setChangeListener(this);
              answerButton.setChangeListener(this);
              
              Font myFont = Font.getDefault().derive(Font.BOLD);
              
              bonusQuestion = "This is a bonus question test blah blah blah blah blah blah blah.";
              LabelField questionLabelField = new LabelField("Question:");
              questionLabelField.setFont(myFont);
              add(questionLabelField);
              add(new LabelField(bonusQuestion));
              add(new LabelField(""));

              answerField = new EditField("", "", 200, EditField.NO_LEARNING 
              		| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
              LabelField answerLabelField = new LabelField("Answer:");
              answerLabelField.setFont(myFont);
              add(answerLabelField);
              add(answerField);
              
              add(new SeparatorField());
              
              HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
              buttonManager.add(answerButton);
              buttonManager.add(backButton);
              buttonManager.add(exitButton);
              add(buttonManager);
       }
       public void fieldChanged(Field field, int context) {
              if (field == backButton) {
                  UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
              }
              if (field == exitButton){
            	  System.exit(0);
              }
              if (field == answerButton){
                  UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
              }
       }
} 
