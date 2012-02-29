/*
 * GridFlowFieldManager.java
 *
 * Research In Motion Limited proprietary and confidential
 * Copyright Research In Motion Limited, 2008-2008
 */

 
package com.rim.device.api.ui.container;


import net.rim.device.api.ui.container.*;

/**
 * 
 */
public class GridFlowFieldManager extends FlowFieldManager {
    
    public GridFlowFieldManager() {
        this( 0 );
    }
    
    public GridFlowFieldManager( long style ) {
        super( style );
    }
    
    /*
    protected int moveFocus(int amount, int status, int time) {
        
        int axis = getNavigationAxis(status);
        // TODO should we realy clamp?
        int amountSign = MathUtilities.clamp( -1, amount, 1 );
        
        int nextFocusIndex = nextFocus( amountSign, axis );
        if( nextFocusIndex < 0) {
            // This will prevent the focus from moving left and right when at the top and bottom row, respectively
            return super.moveFocus( 0, status, time );
        }
        
        return super.moveFocus( amount, status, time );
    }
    */
}

