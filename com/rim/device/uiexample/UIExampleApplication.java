
package com.rim.device.uiexample;

import net.rim.device.api.ui.UiApplication;

public class UIExampleApplication extends UiApplication
{
    public static void main(String[] args)
    { 
        // Create a new instance of the application and start
    	UIExampleApplication application = new UIExampleApplication();
    	application.enterEventDispatcher();
    }

    // Push the index screen
    public UIExampleApplication()
    {
        pushScreen( new UIExampleIndexScreen() );
        
    }    
}
