package com.coolots.chaton.common.coolotsinterface;

import android.content.Context;
import android.text.format.DateFormat;
import com.sds.coolots.common.controller.NativeFormatInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class NativeFormat implements NativeFormatInterface {
    private static final String CLASSNAME = "[NativeFormat]";

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.sds.coolots.common.controller.NativeFormatInterface
    public String getSystemDateFormatString(Context context) {
        StringBuffer dateF = new StringBuffer();
        char[] formatArray = DateFormat.getDateFormatOrder(context);
        if (formatArray != null && formatArray.length > 0) {
            for (int i = 0; i < formatArray.length; i++) {
                if (formatArray[i] == 'y') {
                    dateF.append("yyyy-");
                }
                if (formatArray[i] == 'M') {
                    dateF.append("MM-");
                }
                if (formatArray[i] == 'd') {
                    dateF.append("dd-");
                }
            }
            dateF.deleteCharAt(dateF.length() - 1);
        }
        logI("dateFormat = " + dateF.toString());
        return dateF.toString();
    }

    @Override // com.sds.coolots.common.controller.NativeFormatInterface
    public String getSystemTimeFormatString(Context context) {
        String timeFormat = NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS;
        if (!DateFormat.is24HourFormat(context)) {
            timeFormat = NativeFormatInterface.DISPLAY_TIME_AS_12_HOURS;
        }
        logI("timeFormat = " + timeFormat);
        return timeFormat;
    }
}
