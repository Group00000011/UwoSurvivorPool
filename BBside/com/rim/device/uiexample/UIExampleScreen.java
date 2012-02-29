/*
 * UIExampleScreen.java
 *
 * © Research In Motion Limited, 2006
 * Confidential and proprietary.
 */

package com.rim.device.uiexample;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


/**
 * The base screen for all the screens in the UIExample Project
 */
public class UIExampleScreen extends MainScreen 
{  
    UIExampleScreen( ) 
    {
        this( 0 );
    }
    
    UIExampleScreen( long style ) 
    {
        super( style );
    }
        
    public void setTitle( String title )
    {
        LabelField titleLabel = new LabelField( title );
        titleLabel.setPadding( 4, 0, 3, 4 );
        titleLabel.setFont( titleLabel.getFont().derive( Font.PLAIN, titleLabel.getFont().getHeight() + 2 ) );
        super.setTitle( titleLabel );
    }
}
