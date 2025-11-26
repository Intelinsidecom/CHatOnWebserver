package com.sec.chaton.chat.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.x */
/* loaded from: classes.dex */
class C1128x extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4538a;

    private C1128x(ScreenNotification2 screenNotification2) {
        this.f4538a = screenNotification2;
    }

    /* synthetic */ C1128x(ScreenNotification2 screenNotification2, RunnableC1118n runnableC1118n) {
        this(screenNotification2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            if (C3250y.f11735c) {
                C3250y.m11453c("BR - ACTION_SCREEN_ON", ScreenNotification2.f4381d);
            }
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            if (C3250y.f11735c) {
                C3250y.m11453c("BR - ACTION_SCREEN_OFF", ScreenNotification2.f4381d);
            }
            if (this.f4538a.m5412l()) {
                if (this.f4538a.f4418s == 10 || this.f4538a.f4397P) {
                    this.f4538a.m5424b();
                }
            }
        }
    }
}
