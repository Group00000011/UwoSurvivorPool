import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.io.IOUtilities;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;


public class SplashScreen extends MainScreen implements FieldChangeListener {
	private BitmapField logoBitmapField;
    private EditField usernameField;
    private ButtonField loginButton;
    private ButtonField exitButton;
    private StringBuffer sb1 = null;
	private FileConnection fconn = null;

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
            	  
				try {
					fconn = (FileConnection)Connector.open("file:///SDCard/BlackBerry/filename.txt", Connector.READ_WRITE);
				} catch (IOException e) {
					e.printStackTrace();
				}
            	  	if (fconn.exists())
            	  	{
            	  		InputStream input = null;
						try {
							input = fconn.openDataInputStream();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
            	  		sb1 = new StringBuffer();
            	  		int chars,i=0;
            	  		try {
							while((chars=input.read())!=-1)
							{
								if ((chars=input.read())==32){
									String str=sb1.toString();
									if (usernameField.getText().compareTo(str) == 0){
				            	  		MainmenuScreen mms = new MainmenuScreen();
				            	  		UiApplication.getUiApplication().pushScreen(mms); 
				            	  		this.close();
				            	  	}
									else 
				            	  		sb1 = new StringBuffer();
								}
								else
									sb1.append((char)chars);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
            	  	}
              }
    	   	  //if quit button is pressed exit
              if (field == exitButton) {
            	  System.exit(0);
              }
       }
} 
