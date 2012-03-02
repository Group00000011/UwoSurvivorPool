
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.RichList;
import net.rim.device.api.ui.container.*;


public class PickWinnerScreen extends MainScreen implements FieldChangeListener {
	private ButtonField backButton;
    private ButtonField exitButton;
    private ButtonField pickButton;
    private EditField pickField;
    private BitmapField logoBitmapField;
        
    private String contestantName[] = {"Bill Black", "Joe Cool", "Jim Bob", "Mary Anne", "Anne Smith"};
    private String tribeName[] = {"Cats", "Dogs", "Dogs", "Dogs", "Cats", "Cats", "Cats"};
      
    public PickWinnerScreen() {
              super(NO_VERTICAL_SCROLL);
    	   
    	      Bitmap logoBitmap = Bitmap.getBitmapResource("PW.png");
              logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
              add(logoBitmapField);
           
              Manager mainManager = getMainManager();
              Font myFont = Font.getDefault().derive(Font.BOLD);
              RichList list = new RichList(mainManager, true, 2, 1);
                        
              for(int i=0; i < contestantName.length; i++){
            	  
            	  //String imageFileName = contestantName[i] + ".png";
            	  String imageFileName = "Standings.png";
                  Bitmap bitmap = Bitmap.getBitmapResource(imageFileName);           	          	
                  list.add(new Object[] {bitmap, "Name: " + contestantName[i], "Tribe: " + tribeName[i], ""});
              }
              
              backButton = new ButtonField("Back");
              exitButton = new ButtonField("Quit");
              pickButton = new ButtonField("Pick");
              backButton.setChangeListener(this);
              exitButton.setChangeListener(this);
              pickButton.setChangeListener(this);
              
              pickField = new EditField("", "", 200, EditField.NO_LEARNING 
                		| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
              LabelField pickLabelField = new LabelField("Enter Picks Name:");
              pickLabelField.setFont(myFont);
              add(pickLabelField);
              add(pickField);   
              
              add(new SeparatorField());
              
              HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
              buttonManager.add(pickButton);
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
           if (field == pickButton){
               UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
            }
    }
} 
