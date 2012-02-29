/*
 * UIExampleGaugeScreen.java
 *
 * © Research In Motion Limited, 2006
 * Confidential and proprietary.
 */
 
package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.*;

/**
 * 
 */
public class UIExampleGaugeScreen extends UIExampleScreen
{
    
    public UIExampleGaugeScreen() {
        super( VERTICAL_SCROLL );
        setTitle("BitmapGaugeField");
        
        
        LabelField guageLabel = new LabelField( "Similar to a slider, but not user-changable. Using bitmaps allows for some interesting implementations." );
        guageLabel.setPadding(5, 5, 5, 5);
        add( guageLabel );
        
        
        Bitmap gaugeBack2 = Bitmap.getBitmapResource( "gauge_back_2.png" );
        Bitmap gaugeProgress2 = Bitmap.getBitmapResource( "gauge_progress_2.png" );
        BitmapGaugeField bitGauge2 = new BitmapGaugeField( gaugeBack2, gaugeProgress2, 10, 5, 7, 7, 3, 3, true );
        bitGauge2.setPadding(15,5,15,5);
        add(bitGauge2);    
        add( new NullField( Field.FOCUSABLE ) );  
        
        Bitmap gaugeBack3 = Bitmap.getBitmapResource( "gauge_back_3.png" );
        Bitmap gaugeProgress3 = Bitmap.getBitmapResource( "gauge_progress_3.png" );
        BitmapGaugeField bitGauge3 = new BitmapGaugeField( gaugeBack3, gaugeProgress3, 10, 6, 14, 14, 14, 14, true );
        bitGauge3.setPadding(15,5,15,5);
        add(bitGauge3);    
        add( new NullField( Field.FOCUSABLE ) );  
        
        Bitmap gaugeBack5 = Bitmap.getBitmapResource( "gauge_back_5.png" );
        Bitmap gaugeProgress5 = Bitmap.getBitmapResource( "gauge_progress_5.png" );
        BitmapGaugeField bitGauge5 = new BitmapGaugeField( gaugeBack5, gaugeProgress5, 10, 4, 2, 2, 1, 1, true );
        bitGauge5.setPadding(15,5,15,5);
        add(bitGauge5);       
        add( new NullField( Field.FOCUSABLE ) );  
        
        Bitmap gaugeBack6 = Bitmap.getBitmapResource( "battery_back.png" );
        Bitmap gaugeProgress6 = Bitmap.getBitmapResource( "battery_progress.png" );
        BitmapGaugeField bitGauge6 = new BitmapGaugeField( gaugeBack6, gaugeProgress6, 10, 4, 4, 15, 4, 15, true );
        int xmargin = Display.getWidth() / 4;
        bitGauge6.setPadding(15,xmargin,15,xmargin);
        add(bitGauge6);   
        add( new NullField( Field.FOCUSABLE ) );  
        
    }
}
