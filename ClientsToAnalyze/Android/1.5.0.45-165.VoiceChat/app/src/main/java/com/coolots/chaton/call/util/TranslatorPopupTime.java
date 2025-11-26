package com.coolots.chaton.call.util;

import android.content.Context;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.NativeFormatInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class TranslatorPopupTime {
    public String getCurrentTime(Context context) {
        SimpleDateFormat formatter;
        Date rightNow = new Date();
        if (MainApplication.mNativeFormat.getSystemTimeFormatString(context) == NativeFormatInterface.DISPLAY_TIME_AS_12_HOURS) {
            formatter = new SimpleDateFormat("h:mm a", MainApplication.mContext.getResources().getConfiguration().locale);
        } else {
            formatter = new SimpleDateFormat("HH:mm", MainApplication.mContext.getResources().getConfiguration().locale);
        }
        String curTime = formatter.format(rightNow);
        return curTime;
    }
}
