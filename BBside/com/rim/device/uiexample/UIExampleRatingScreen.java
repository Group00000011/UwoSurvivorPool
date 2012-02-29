/*
 * UIExampleRatingScreen.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.uiexample;


import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;

import com.rim.device.api.ui.component.*;
import com.rim.device.api.ui.container.*;


public class UIExampleRatingScreen extends UIExampleScreen
{
    public UIExampleRatingScreen() {
        
        super( NO_VERTICAL_SCROLL | USE_ALL_HEIGHT );
        setTitle( "RatingField Examples" );
        
        int labelColor = 0xFFFFFF; // white
        
        NegativeMarginVerticalFieldManager ratingManager = new NegativeMarginVerticalFieldManager( VERTICAL_SCROLL | USE_ALL_WIDTH | USE_ALL_HEIGHT ) {
            protected void paintBackground( Graphics g )
            {
                int oldColor = g.getColor();
                try {
                    g.setColor( 0x222222 );
                    g.fillRect( 0, getVerticalScroll(), getWidth(), getHeight() );
                } finally {
                    g.setColor( oldColor );
                }
            }   
        };

        
        ColoredLabelField labelOne = new ColoredLabelField( "Main Course", labelColor, Field.FIELD_HCENTER );
        labelOne.setMargin( 25, 0,7, 0 );
        
        RatingField rating = new RatingField( Bitmap.getBitmapResource( "rating_star.png" )
                                            , Bitmap.getBitmapResource( "rating_dot.png" )
                                            , Bitmap.getBitmapResource( "rating_star_focus.png" )
                                            , Bitmap.getBitmapResource( "rating_dot_focus.png" )
                                            , 5, 4, Field.FIELD_HCENTER );
        rating.setMargin( 7, 0, 15, 0 );
        ratingManager.add( labelOne );
        ratingManager.add( rating );
        
        
        ColoredLabelField labelTwo = new ColoredLabelField( "Wine", labelColor, Field.FIELD_HCENTER );
        labelTwo.setMargin( 25, 0, 7, 0 );
        
        RatingField rating2 = new RatingField( Bitmap.getBitmapResource( "rating_star.png" )
                                            , Bitmap.getBitmapResource( "rating_dot.png" )
                                            , Bitmap.getBitmapResource( "rating_star_focus.png" )
                                            , Bitmap.getBitmapResource( "rating_dot_focus.png" )
                                            , 5, 1, Field.FIELD_HCENTER );
        rating2.setMargin( 7, 0, 15, 0 );
        ratingManager.add( labelTwo );
        ratingManager.add( rating2 );
        
        
        ColoredLabelField labelThree = new ColoredLabelField( "Dessert", labelColor, Field.FIELD_HCENTER );
        labelThree.setMargin( 25, 0, 7, 0 );
        
        RatingField rating3 = new RatingField( Bitmap.getBitmapResource( "rating_star.png" )
                                            , Bitmap.getBitmapResource( "rating_dot.png" )
                                            , Bitmap.getBitmapResource( "rating_star_focus.png" )
                                            , Bitmap.getBitmapResource( "rating_dot_focus.png" )
                                            , 5, 5, Field.FIELD_HCENTER );
        rating3.setMargin( 7, 0, 15, 0 );
        ratingManager.add( labelThree );
        ratingManager.add( rating3 );
        
        
        VerticalButtonFieldSet buttonManager = new VerticalButtonFieldSet( USE_ALL_WIDTH );
        buttonManager.add( new ButtonField( "Save Review" ) );
        buttonManager.setMargin( 30, 30, 25, 30 );
        ratingManager.add( buttonManager );
        
        add( ratingManager );
        
    }
	
}

