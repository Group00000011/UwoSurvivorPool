/*
 * ListStyleButtonSet.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2009-2009
 */

package com.rim.device.api.ui.container;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.container.*;
import com.rim.device.api.ui.component.*;

/**
 * 
 */
public class ListStyleButtonSet extends VerticalFieldManager 
{
    public static final int MARGIN = 15;
    
    public ListStyleButtonSet()
    {
        super( NO_VERTICAL_SCROLL );
        setMargin( MARGIN, MARGIN, MARGIN, MARGIN );
    }
    
    protected void sublayout( int maxWidth, int maxHeight )
    {
        super.sublayout( maxWidth, maxHeight );
        
        int numChildren = this.getFieldCount();
        if( numChildren > 0 ) {
            if( numChildren == 1 ) {
                Field child = getField( 0 );
                if( child instanceof ListStyleButtonField ) {
                    ( (ListStyleButtonField) child ).setDrawPosition( ListStyleButtonField.DRAWPOSITION_SINGLE );
                }
            } else {
                int index = 0;
                Field child = getField( index );
                if( child instanceof ListStyleButtonField ) {
                    ( (ListStyleButtonField) child ).setDrawPosition( ListStyleButtonField.DRAWPOSITION_TOP );
                }
                for( index = 1; index < numChildren - 1 ; index++ ) {
                    child = getField( index );
                    if( child instanceof ListStyleButtonField ) {
                        ( (ListStyleButtonField) child ).setDrawPosition( ListStyleButtonField.DRAWPOSITION_MIDDLE );
                    }
                }
                child = getField( index );
                if( child instanceof ListStyleButtonField ) {
                    ( (ListStyleButtonField) child ).setDrawPosition( ListStyleButtonField.DRAWPOSITION_BOTTOM );
                }
            }
        }
    }
}
