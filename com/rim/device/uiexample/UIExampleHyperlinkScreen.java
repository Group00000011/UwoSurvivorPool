/*
 * UIExampleHyperlinkScreen.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.uiexample;


import com.rim.device.api.ui.component.*;



/**
 * 
 */
public class UIExampleHyperlinkScreen extends UIExampleScreen
{
    public UIExampleHyperlinkScreen() {
        
        setTitle( "HyperlinkButtonField" );
        
        addLink( "BitmapButton" );
        addLink( "Custom Buttons" );
        addLink( "Calendar Range Selection" );
        addLink( "Colour Picker" );
        addLink( "Gauge" );
        addLink( "ListStyleButton" );
        addLink( "Searchable Collection" );
        addLink( "Slider" );
        addLink( "Switch" );
        addLink( "Transitions" );
        addLink( "Transition Cube" );
    }
    
    private void addLink( final String label )
    {
        add( new MyHyperlinkButtonField( label ) );
    }
    
    class MyHyperlinkButtonField extends HyperlinkButtonField
    {
        MyHyperlinkButtonField( String label ) {
            super( label, 0x0000FF, 0xFFFFFF, 0x0000FF, 0, 0 );
            setPadding( 8, 5, 8, 5 );
        }
    }
}
