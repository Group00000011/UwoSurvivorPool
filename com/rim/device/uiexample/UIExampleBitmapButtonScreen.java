/*
 * UIExampleBitmapButtonScreen.java
 *
 * © Research In Motion Limited, 2006
 * Confidential and proprietary.
 */

package com.rim.device.uiexample;


import com.rim.device.api.ui.component.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

class MediaControlStyleField extends HorizontalFieldManager
{
    MediaControlStyleField()
    {
        super(Manager.FIELD_HCENTER);
        
        add( new BitmapButtonField(Bitmap.getBitmapResource("prev.png"), Bitmap.getBitmapResource("prev_focus.png") ));
        add( new BitmapButtonField(Bitmap.getBitmapResource("play.png"), Bitmap.getBitmapResource("play_focus.png") ));
        add( new BitmapButtonField(Bitmap.getBitmapResource("stop.png"), Bitmap.getBitmapResource("stop_focus.png") ));
        add( new BitmapButtonField(Bitmap.getBitmapResource("next.png"), Bitmap.getBitmapResource("next_focus.png") ));
        
        setPadding(5,5,5,5);
        setMargin( 10, 10, 10, 10 );
    }
    
    protected void paintBackground( Graphics g )
    {
        int oldColor = g.getColor();
        try {
            g.setColor( 0x222222 );
            g.fillRoundRect( 0, 0, getWidth(), getHeight(), 20, 20 );
            g.setColor( 0x000000 );
            g.drawRoundRect( 0, 0, getWidth(), getHeight(), 20 ,20 );
        } finally {
            g.setColor( oldColor );
        }
    }
    
}
/*
class RadioControlStyleField extends HorizontalFieldManager
{
    RadioControlStyleField()
    {
        super(Manager.FIELD_HCENTER);
        
        Bitmap nextPrevBurst = Bitmap.getBitmapResource("radio_next_prev_burst.png");
        BitmapBurstButtonField prev = new BitmapBurstButtonField( Bitmap.getBitmapResource("radio_prev_unfocus.png"), Bitmap.getBitmapResource("radio_prev_focus.png"), nextPrevBurst, Field.FIELD_VCENTER );
        BitmapBurstButtonField play = new BitmapBurstButtonField( Bitmap.getBitmapResource("radio_play_unfocus.png"), Bitmap.getBitmapResource("radio_play_focus.png"), Bitmap.getBitmapResource("radio_play_burst.png"), Field.FIELD_VCENTER );
        BitmapBurstButtonField next = new BitmapBurstButtonField( Bitmap.getBitmapResource("radio_next_unfocus.png"), Bitmap.getBitmapResource("radio_next_focus.png"), nextPrevBurst, Field.FIELD_VCENTER );
        
        prev.setMargin( 10, 10, 10, 10 );
        play.setMargin( 10, 10, 10, 10 );
        next.setMargin( 10, 10, 10, 10 );
        
        add( prev );
        add( play );
        add( next );
        
        setPadding( 10, 10, 10, 10 );
        setMargin( 10, 10, 10, 10 );
    }
    
    protected void paintBackground( Graphics g )
    {
        int oldColor = g.getColor();
        try {
            g.setColor( 0x222222 );
            g.fillRoundRect( 0, 0, getWidth(), getHeight(), 20, 20 );
            g.setColor( 0x000000 );
            g.drawRoundRect( 0, 0, getWidth(), getHeight(), 20 ,20 );
        } finally {
            g.setColor( oldColor );
        }
    }
    
}
*/

/**
 * 
 */
public class UIExampleBitmapButtonScreen extends UIExampleScreen
{
    
    public UIExampleBitmapButtonScreen() {
        super( 0 );
        setTitle("BitmapButton Example");
        
        LabelField firstLabel = new LabelField( "BitmapButtonField. Two images of the same dimension create a button." );
        firstLabel.setPadding(5, 5, 5, 5);
        add( firstLabel );
        
        add( new MediaControlStyleField() );
        
        /*
        LabelField burstLabel = new LabelField( "BitmapBurstButtonField. An animated burst occurs when the field gains focus" );
        burstLabel.setPadding(5, 5, 5, 5);
        add( burstLabel );
        
        add( new RadioControlStyleField() );
        */
        
    }
}
