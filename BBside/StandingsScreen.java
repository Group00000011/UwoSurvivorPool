
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.SimpleList;
import net.rim.device.api.ui.container.*;


public class StandingsScreen extends MainScreen implements FieldChangeListener {
       private ButtonField backButton;
       private ButtonField exitButton;
       private BitmapField logoBitmapField;
       private String userName[] = {"mgrabar", "rcool", "bgates", "sjobs", "bjoe", "asskicker", 
    		   "cnoris", "babygurl"};
       private int userScore[] = {1000, 900, 800, 700, 600, 500, 400, 300, 200};

       public StandingsScreen() {
    	   	  super(Manager.NO_VERTICAL_SCROLL);
    	   
    	      Bitmap logoBitmap = Bitmap.getBitmapResource("Standings.png");
              logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
              add(logoBitmapField);
                                   
              Manager mainManager = getMainManager();
              
              SimpleList listField = new SimpleList(mainManager);
 
              for (int i=0; i < userName.length; i++){
              listField.add(i+1 + " | " + userName[i] + ":" + userScore[i]);
              }
              
              backButton = new ButtonField("Back");
              exitButton = new ButtonField("Quit");
              backButton.setChangeListener(this);
              exitButton.setChangeListener(this);
              
              HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT | Manager.VERTICAL_SCROLL);
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
       }
} 
