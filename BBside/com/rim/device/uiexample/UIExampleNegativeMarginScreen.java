/*
 * UIExampleNegativeMarginScreen.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.container.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.decor.*;


/**
 * 
 */
public class UIExampleNegativeMarginScreen extends UIExampleScreen
{
    Manager _foreground;
    
    public UIExampleNegativeMarginScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT );
        setTitle( "NegativeMargins" );
        
        _foreground = new NegativeMarginVerticalFieldManager( USE_ALL_WIDTH | USE_ALL_HEIGHT | VERTICAL_SCROLL );
        
        Border rightBorder = BorderFactory.createBitmapBorder( new XYEdges( 16, 23, 27, 16 ), Bitmap.getBitmapResource( "bubble_right.png" ) );
        Border leftBorder = BorderFactory.createBitmapBorder( new XYEdges( 16, 16, 27, 23 ), Bitmap.getBitmapResource( "bubble_left.png" ) );
        
        addHeading( "See how the bottom of the bubbles overlap the top of the next bubble?", leftBorder, Field.FIELD_LEFT );
        addHeading( "Yeah, I see it", rightBorder, Field.FIELD_RIGHT );
        addHeading( "That's a negative bottom margin", leftBorder, Field.FIELD_LEFT );
        addHeading( "It lets the field below overlap the one above", leftBorder, Field.FIELD_LEFT );
        addHeading( "My presentation is due on the 18th!", rightBorder, Field.FIELD_RIGHT );
        addHeading( "Better get on that", leftBorder, Field.FIELD_LEFT );
        addHeading( "No worries, I'll finish it", rightBorder, Field.FIELD_RIGHT );
        addHeading( "The night before?", leftBorder, Field.FIELD_LEFT );
        addHeading( "Probably", rightBorder, Field.FIELD_RIGHT );
        
        NegativeMarginHorizontalFieldManager horizontalExample = new NegativeMarginHorizontalFieldManager( USE_ALL_WIDTH );
        addButton( horizontalExample, "One" );
        addButton( horizontalExample, "Two" );
        addButton( horizontalExample, "Three" );
        addButton( horizontalExample, "Four" );
        addButton( horizontalExample, "Five" );
        
        _foreground.add( horizontalExample );
        horizontalExample.setMargin( 25, 0, 0, 0 );
        add( _foreground );
    }
    
    private void addButton( Manager parent, String text ) 
    {
        ButtonField button = new ButtonField( text, Field.FOCUSABLE );
        button.setMargin( 5, -18, 5, 5 );
        parent.add( button );
    }
    
    
    private void addHeading( String label, Border border, long style ) 
    {
        LabelField header = new LabelField( label, Field.FOCUSABLE | style );
        header.setBorder( border );
        header.setMargin( 5, 5, -15, 5 );
        _foreground.add( header );
    }
    
    
}
