import net.rim.device.api.ui.UiApplication;
/**
 * UwoSurvivorPool class contains the main method for the Survival Pool Application (initiates the program)
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff Westaway, Delerina Hill
 *
 */
public class UWOSurvivorPool extends UiApplication {
        public static void main (String[] args) {
        	UWOSurvivorPool splash = new UWOSurvivorPool();
            splash.enterEventDispatcher();
      }
       /**
        * Constructor for beginning Survival Pool game
        */
       public UWOSurvivorPool() {
           pushScreen (new SplashScreen());
       }

}