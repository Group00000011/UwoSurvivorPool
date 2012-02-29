/*
 * UIExampleLabeledSwitchScreen.java
 *
 * © Research In Motion Limited, 2006
 * Confidential and proprietary.
 */

package com.rim.device.uiexample;

import com.rim.device.api.ui.component.*;
import com.rim.device.api.ui.container.*;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.component.*;

/**
 * 
 */
public class UIExampleLabeledSwitchScreen extends UIExampleScreen
{
    
    public UIExampleLabeledSwitchScreen()
    {
        setTitle("LabeledSwitch Example");
        
        LabelField switchLabel = new LabelField( "LabeledSwitch. Like a switch, but with a small state label." );
        switchLabel.setPadding(5, 5, 5, 5);
        add( switchLabel );
        
        Bitmap switch_left = Bitmap.getBitmapResource("switch_left.png");
        Bitmap switch_right = Bitmap.getBitmapResource("switch_right.png");
        Bitmap switch_left_focus = Bitmap.getBitmapResource("switch_left_focus.png");
        Bitmap switch_right_focus = Bitmap.getBitmapResource("switch_right_focus.png");

        LabeledSwitch callSwitch = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "on", "off", true );
        JustifiedHorizontalFieldManager phoneCalls = new JustifiedHorizontalFieldManager( new LabelField( "Phone Calls" ), callSwitch, false, USE_ALL_WIDTH );
        phoneCalls.setPadding(5,5,5,5);
        add(phoneCalls);

        LabeledSwitch msgSwitch = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "on", "off", false );
        JustifiedHorizontalFieldManager messages = new JustifiedHorizontalFieldManager( new LabelField( "Messages" ), msgSwitch, false, USE_ALL_WIDTH );
        messages.setPadding(5,5,5,5);
        add(messages);
        
        LabeledSwitch reminderSwitch = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "on", "off", true );
        JustifiedHorizontalFieldManager reminders = new JustifiedHorizontalFieldManager( new LabelField( "Reminders" ), reminderSwitch, false, USE_ALL_WIDTH );
        reminders.setPadding(5,5,5,5);
        add(reminders);
    }
}
