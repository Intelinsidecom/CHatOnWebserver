package com.sds.coolots.common.controller;

import android.content.Context;

/* loaded from: classes.dex */
public interface NativeFormatInterface {
    public static final String DISPLAY_DATE_AS_DDMMYYYY = "dd-MM-yyyy";
    public static final String DISPLAY_DATE_AS_MMDDYYYY = "MM-dd-yyyy";
    public static final String DISPLAY_DATE_AS_YYYYMMDD = "yyyy-MM-dd";
    public static final String DISPLAY_TIME_AS_12_HOURS = "12";
    public static final String DISPLAY_TIME_AS_24_HOURS = "24";

    String getSystemDateFormatString(Context context);

    String getSystemTimeFormatString(Context context);
}
