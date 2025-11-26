package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ei */
/* loaded from: classes.dex */
class C2315ei extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8238a;

    C2315ei(TabActivity tabActivity) {
        this.f8238a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8238a.m3062p();
    }
}
