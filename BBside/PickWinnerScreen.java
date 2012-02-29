
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


public class PickWinnerScreen extends MainScreen implements FieldChangeListener {
       private ButtonField backButton;
       private ButtonField exitButton;

       public PickWinnerScreen() {
              super();
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
