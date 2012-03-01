
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


public class PickWinnerScreen extends MainScreen implements FieldChangeListener {
       private ButtonField backButton;
       private ButtonField exitButton;
       private BitmapField logoBitmapField;

       public PickWinnerScreen() {
              //super();
    	   
    	      Bitmap logoBitmap = Bitmap.getBitmapResource("PW.png");
              logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
              add(logoBitmapField);
           
              backButton = new ButtonField("Back");
              exitButton = new ButtonField("Quit");
              backButton.setChangeListener(this);
              exitButton.setChangeListener(this);
              this.add(backButton);
              this.add(exitButton);
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
