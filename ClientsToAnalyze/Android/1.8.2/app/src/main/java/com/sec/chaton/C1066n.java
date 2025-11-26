package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.n */
/* loaded from: classes.dex */
class C1066n extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f3960a;

    C1066n(HomeActivity homeActivity) {
        this.f3960a = homeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).unregisterReceiver(this.f3960a.f222m);
        this.f3960a.f222m = null;
        this.f3960a.startActivity(new Intent(this.f3960a, (Class<?>) ExitAppDialogActivity.class));
    }
}
