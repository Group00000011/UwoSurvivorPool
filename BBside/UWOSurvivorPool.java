import net.rim.device.api.ui.UiApplication;

public class UWOSurvivorPool extends UiApplication {
        public static void main (String[] args) {
        	UWOSurvivorPool splash = new UWOSurvivorPool();
            splash.enterEventDispatcher();
      }

       public UWOSurvivorPool() {
           pushScreen (new SplashScreen());
       }

}