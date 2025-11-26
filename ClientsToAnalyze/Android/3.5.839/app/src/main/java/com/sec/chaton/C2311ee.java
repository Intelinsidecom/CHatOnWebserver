package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ee */
/* loaded from: classes.dex */
class C2311ee extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8234a;

    C2311ee(TabActivity tabActivity) {
        this.f8234a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8234a.m3067r();
    }
}
