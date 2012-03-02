import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

import net.rim.device.api.io.IOUtilities;
import net.rim.device.api.system.Bitmap;



public class SplashScreen extends MainScreen implements FieldChangeListener {
	private BitmapField logoBitmapField;
    private EditField usernameField;
    private ButtonField loginButton;
    private ButtonField exitButton;
    private String userName;

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
    	   	  //if login button is pressed search text file for username
              if (field == loginButton) {   
            	  userName = readFile("Usernames.txt");
            	  
            	  if (usernameField.getText().compareTo(userName) == 0){
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
       
       private String readFile(String filePath) {
    	   String result = null;
    	   InputStream input = null;
    	   FileConnection fconn = null;
    	   try {
    	   fconn = (FileConnection) Connector.open("file:///SDCard/BlackBerry/" + filePath, Connector.READ);
    	   if (fconn.exists()) {
    	   input = fconn.openInputStream();
    	   byte[] bytes = IOUtilities.streamToBytes(input);
    	   // it might be advisable to specify an encoding on the next line.
    	   result = new String(bytes);
    	   } else {
    		   add(new LabelField("no file"));
    	   }
    	   } catch (Exception ioe) {
    		   add(new LabelField("error"));
    	   } finally {
    	   if (input != null) try { input.close(); } catch (IOException ignored) {}
    	   if (fconn != null) try { fconn.close(); } catch (IOException ignored) {}
    	   }
    	   return result;
    	   }

} 
