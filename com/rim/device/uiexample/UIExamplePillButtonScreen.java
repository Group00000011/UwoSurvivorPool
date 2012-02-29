/*
 * UIExamplePillButtonScreen.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;
import com.rim.device.api.ui.container.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


/**
 * 
 */
public class UIExamplePillButtonScreen extends UIExampleScreen
{
    Manager _contentOne;
    Manager _contentTwo;
    Manager _contentThree;
    
    Manager _bodyWrapper;
    Manager _currentBody;
    
    public UIExamplePillButtonScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT | USE_ALL_WIDTH );
        setTitle( "Pill Button Sets" );
        
        Manager foreground = new ForegroundManager();
        
        PillButtonSet pills = new PillButtonSet();
        PillButtonField pillOne = new PillButtonField( "Contact" );
        PillButtonField pillTwo = new PillButtonField( "Address" );
        PillButtonField pillThree = new PillButtonField( "Photos" );
        pills.add( pillOne );
        pills.add( pillTwo );
        pills.add( pillThree );
        pills.setMargin( 15, 15, 5, 15 );
        foreground.add( pills );
        
        
        _bodyWrapper = new NegativeMarginVerticalFieldManager( USE_ALL_WIDTH );
        
        _contentOne = new ListStyleButtonSet();
        _contentOne.add( new ListStyleButtonField( "Home", 0 ) );
        _contentOne.add( new ListStyleButtonField( "Mobile", 0  ) );
        _contentOne.add( new ListStyleButtonField( "Fax", 0  ) );
        _contentOne.add( new ListStyleButtonField( "PIN", 0  ) );
        
        _contentTwo = new ListStyleButtonSet();
        _contentTwo.add( new ListStyleButtonField( "Home Address", 0  ) );
        _contentTwo.add( new ListStyleButtonField( "Work Address", 0  ) );
        
        _contentThree = new FlowFieldManager();
        _contentThree.setMargin( 10, 10, 10, 10 );
        
        BitmapField photo1 = new BitmapField( Bitmap.getBitmapResource( "golf.png" ) );
        BitmapField photo2 = new BitmapField( Bitmap.getBitmapResource( "grass.png" ) );
        BitmapField photo3 = new BitmapField( Bitmap.getBitmapResource( "storm.png" ) );
        BitmapField photo4 = new BitmapField( Bitmap.getBitmapResource( "summit.png" ) );
        BitmapField photo5 = new BitmapField( Bitmap.getBitmapResource( "violin.png" ) );
        photo1.setMargin( 5, 5, 5, 5 );
        photo2.setMargin( 5, 5, 5, 5 );
        photo3.setMargin( 5, 5, 5, 5 );
        photo4.setMargin( 5, 5, 5, 5 );
        photo5.setMargin( 5, 5, 5, 5 );
        _contentThree.add( photo1 );
        _contentThree.add( photo2 );
        _contentThree.add( photo3 );
        _contentThree.add( photo4 );
        _contentThree.add( photo5 );

        pills.setSelectedField( pillOne );
        _currentBody = _contentOne;
        _bodyWrapper.add( _currentBody );
        
        
        pillOne.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentOne ) {
	                _bodyWrapper.replace( _currentBody, _contentOne );
	                _currentBody = _contentOne;
            	}
            }
        } );
        
        pillTwo.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentTwo ) {
	                _bodyWrapper.replace( _currentBody, _contentTwo );
	                _currentBody = _contentTwo;
            	}
            }
        } );
        
        pillThree.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentThree ) {
	                _bodyWrapper.replace( _currentBody, _contentThree );
	                _currentBody = _contentThree;
            	}
            }
        } );
        
        foreground.add( _bodyWrapper );
        add( foreground );
    }
    
}

