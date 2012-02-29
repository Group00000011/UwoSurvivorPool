/*
 * HorizontalListStyleButtonSet.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.api.ui.container;

import com.rim.device.api.ui.component.*;
import net.rim.device.api.ui.*;

/**
 * 
 */
public class HorizontalListStyleButtonSet extends JustifiedEvenlySpacedHorizontalFieldManager 
{
    public static final int MARGIN = 15;
    
    public HorizontalListStyleButtonSet()
    {
    }
    
    protected void sublayout( int maxWidth, int maxHeight )
    {
        Field child;
        int numChildren = this.getFieldCount();
        for( int index = 0; index < numChildren ; index++ ) {
            child = getField( index );
            if( child instanceof ListStyleButtonField ) {
                ListStyleButtonField button = ( (ListStyleButtonField) child );
                button.setDrawPosition( ListStyleButtonField.DRAWPOSITION_SINGLE );
                button.setMargin( MARGIN, MARGIN, MARGIN, MARGIN );
            }
        }
        
        super.sublayout( maxWidth, maxHeight );
    }
}
