import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;


public class SplashScreen extends MainScreen implements FieldChangeListener {
	private BitmapField logoBitmapField;
    private EditField usernameField;
    private ButtonField loginButton;
    private ButtonField exitButton;


    public SplashScreen() {
    	   
    	Bitmap logoBitmap = Bitmap.getBitmapResource("Survivorlogo.png");
        logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
        add(logoBitmapField);
           
        add(new SeparatorField());

        usernameField = new EditField("", "", 200, EditField.NO_LEARNING 
        		| EditField.NO_NEWLINE | EditField.NO_COMPLEX_INPUT);
        add(new LabelField("Username:"));
        add(usernameField);

        add(new SeparatorField());

        loginButton = new ButtonField("Login", ButtonField.CONSUME_CLICK);
        loginButton.setChangeListener(this);
        exitButton = new ButtonField("Quit", ButtonField.CONSUME_CLICK);
        exitButton.setChangeListener(this);
        HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
        buttonManager.add(loginButton);
        buttonManager.add(exitButton);
        add(buttonManager);
   }


       public void fieldChanged(Field field, int context) {
    	   	  //if quit button is pressed exit
              if (field == loginButton) {
            	  if (usernameField.getText().compareTo("test") == 0){
            		  MainmenuScreen mms = new MainmenuScreen();
                      UiApplication.getUiApplication().pushScreen(mms); 
                      this.close();
            	  }
              }
    	   	  //if quit button is pressed exit
              if (field == exitButton) {
            	  System.exit(0);
              }
       }
} 
