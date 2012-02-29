/*
 * UIExampleProgressAnimationScreen.java
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

public class UIExampleProgressAnimationScreen extends UIExampleScreen
{
    public UIExampleProgressAnimationScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT );
        setTitle( "Progress Animations" );
        
        EvenlySpacedHorizontalFieldManager spinners = new EvenlySpacedHorizontalFieldManager( USE_ALL_WIDTH );
        addSpinner( spinners, new ProgressAnimationField( Bitmap.getBitmapResource( "spinner2.png" ), 6, Field.FIELD_HCENTER ) );
        addSpinner( spinners, new ProgressAnimationField( Bitmap.getBitmapResource( "spinner.png" ), 5, Field.FIELD_HCENTER ) );
        
        add( spinners );
        
        Bitmap progressBitmap = Bitmap.getBitmapResource( "progress.png" );
        ProgressAnimationField example = new ProgressAnimationField( progressBitmap, 4, Field.FIELD_HCENTER );
        LabelField exampleLabel = new LabelField( "The progress / spinner fields are created using a single image that has different frames in it. You pass in the image, and the number of equal size horizontal frames. It will take care of the animation." );
        exampleLabel.setMargin( 10, 10, 10, 10 );
    
        add( exampleLabel );
        
        EvenlySpacedHorizontalFieldManager spinners2 = new EvenlySpacedHorizontalFieldManager( USE_ALL_WIDTH );
        addSpinner( spinners2, example );
        addSpinner( spinners2, new BitmapField( progressBitmap ) );
        add( spinners2 );
    }
    
    private void addSpinner( Manager parent, Field spinner )
    {
        spinner.setMargin( 15, 15, 15, 15 );
        parent.add( spinner );
    }
}

