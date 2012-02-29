/*
 * UIExampleSliderScreen.java
 *
 * © Research In Motion Limited, 2006
 * Confidential and proprietary.
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.component.*;


public class UIExampleSliderScreen extends UIExampleScreen
{
    
    public UIExampleSliderScreen() {
        super( 0 );
        setTitle("Slider Example");
        
        new ButtonField();
        
        LabelField sliderLabel = new LabelField( "Slider. Composed of a background stretched to fit, and a thumb image. Divided into n positions. " );
        sliderLabel.setPadding(5, 5, 5, 5);
        add( sliderLabel );
        
        Bitmap slider_back = Bitmap.getBitmapResource("slider.png");
        Bitmap slider_focus = Bitmap.getBitmapResource("slider_focus.png");
        Bitmap slider_thumb = Bitmap.getBitmapResource("slider_thumb.png");
        SliderField fifthSlider = new SliderField( slider_thumb, slider_back, slider_focus, 8 , 4, 10, 10 );
        fifthSlider.setPadding( 15, 5, 15, 5 );
        add( fifthSlider );

        SliderField sixthSlider = new SliderField( slider_thumb, slider_back, slider_focus, 8 , 4, 10, 10 );
        sixthSlider.setPadding( 15, 5, 15, 5 );
        add( sixthSlider );
    }
}
