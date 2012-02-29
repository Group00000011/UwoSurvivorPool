/*
 * UIExampleListStyleButtonSetScreen.java
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;
import com.rim.device.api.ui.container.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;



public class UIExampleListStyleButtonSetScreen extends UIExampleScreen
{
    private Bitmap _caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
    private ForegroundManager _foreground;    
        
    public UIExampleListStyleButtonSetScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT );
        setTitle( "ListStyleButtonField Sets" );
        
        _foreground = new ForegroundManager();
        
        
        LabelField verticalLabel = new LabelField( "This field set will automatically round the top and bottom fields, creating a strong association between the elements. Good for grouping related objects in Options screens." );
        verticalLabel.setPadding(5, 15, 5, 15);
        _foreground.add( verticalLabel );
        
        ListStyleButtonSet buttonSet = new ListStyleButtonSet();
       
        ListStyleButtonField link = new ListStyleButtonField( "About", _caret );
        buttonSet.add( link );
        
        link = new ListStyleButtonField( "Owner", _caret );
        buttonSet.add( link );
        
        link = new ListStyleButtonField( "Status", _caret );
        buttonSet.add( link );
        
        _foreground.add( buttonSet );
        
        
        LabelField horizontalLabel = new LabelField( "HorizontalListStyleButtonSet will stack the fields horizontally, giving each an equal amount of space." );
        horizontalLabel.setPadding(5, 15, 5, 15);
        _foreground.add( horizontalLabel );
        
        LabelField horizontalLabel2 = new LabelField( "The ListStyleButtonField also supports Drawstyle.LEFT | RIGHT | HCENTER style bits for text alignment" );
        horizontalLabel2.setPadding(5, 15, 5, 15);
        _foreground.add( horizontalLabel2 );
        
        HorizontalListStyleButtonSet exampleSet = new HorizontalListStyleButtonSet();
        exampleSet.add( new ListStyleButtonField( "Shuffle", DrawStyle.HCENTER ) );
        exampleSet.add( new ListStyleButtonField( "Stop", DrawStyle.HCENTER ) );
        _foreground.add( exampleSet );
        
        add( _foreground );
    }
    
}
