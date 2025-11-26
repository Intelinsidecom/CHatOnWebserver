package com.sec.chaton.chat.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ao */
/* loaded from: classes.dex */
class C1808ao extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6819a;

    private C1808ao(ScreenNotification2 screenNotification2) {
        this.f6819a = screenNotification2;
    }

    /* synthetic */ C1808ao(ScreenNotification2 screenNotification2, HandlerC1835x handlerC1835x) {
        this(screenNotification2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            if (C4904y.f17873c) {
                C4904y.m18641c("BR - ACTION_SCREEN_ON", ScreenNotification2.f6727v);
            }
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && C4904y.f17873c) {
            C4904y.m18641c("BR - ACTION_SCREEN_OFF", ScreenNotification2.f6727v);
        }
    }
}
