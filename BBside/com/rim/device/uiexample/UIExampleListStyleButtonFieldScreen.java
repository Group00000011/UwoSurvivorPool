/*
 * UIExampleListStyleButtonFieldScreen.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;


public class UIExampleListStyleButtonFieldScreen extends UIExampleScreen implements FieldChangeListener
{
    private UIExampleScreen _explanation;
    
    public UIExampleListStyleButtonFieldScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT );
        
        setTitle("ListStyleButtonField Example");
        
        Bitmap caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
        
        ListStyleButtonField one   = new ListStyleButtonField( "Music", caret );
        one.setChangeListener( this );
        add( one );
        
        ListStyleButtonField two   = new ListStyleButtonField( "Photos", caret );
        two.setChangeListener( this );
        add( two );
        
        ListStyleButtonField three = new ListStyleButtonField( "Extras", caret );
        three.setChangeListener( this );
        add( three );
        
        ListStyleButtonField four  = new ListStyleButtonField( "Settings", caret );
        four.setChangeListener( this );
        add( four );
        
        ListStyleButtonField five  = new ListStyleButtonField( "Shuffle Songs", 0 );
        five.setChangeListener( this );
        add( five );
        
        _explanation = new UIExampleScreen();
        _explanation.setTitle( "ListStyleButtonField Explanation" );
        
        LabelField explanationLabel = new LabelField( "The ListStyleButtonField looks like a list row, but is just a simple button. Good for use with a small finite set of elements." );
        explanationLabel.setPadding(5, 5, 5, 5);
        _explanation.add( explanationLabel );
    }
    
    public void fieldChanged( Field field, int context )
    {
        UiApplication.getUiApplication().pushScreen( _explanation );
    }
    
}
