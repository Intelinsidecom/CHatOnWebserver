package com.coolots.chaton.call.view.layout;

/* loaded from: classes.dex */
public class PhoneFeature {
    public static final int FINAL_FEATURE_FLAG = 4;
    public static final int INCOMING_CALL_WIDGET_DESCRIPTION_ENABLE = 2;
    public static final int MOVE_INCOMINGCALLWIDGET_TOUCH_AREA = 4;
    public static final int TABLET_DEVICE = 1;

    public static boolean hasFeature(int flag) {
        return (flag & 4) == flag;
    }
}
