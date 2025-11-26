package com.sds.coolots.common.coolotsinterface;

import android.app.Notification;

/* loaded from: classes.dex */
public interface CallNotificationInterface {
    void deleteCallNotification();

    Notification getQuickPanelNotification();

    void showCallButtonNotification();

    boolean showQuickPanel();

    void showRejectMessageNotification(String str, String str2);
}
