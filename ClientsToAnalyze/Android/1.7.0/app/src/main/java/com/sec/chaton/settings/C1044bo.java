package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.bo */
/* loaded from: classes.dex */
class C1044bo extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f3655a;

    C1044bo(ActivityGeneral activityGeneral) {
        this.f3655a = activityGeneral;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f3655a.m3792b();
    }
}
