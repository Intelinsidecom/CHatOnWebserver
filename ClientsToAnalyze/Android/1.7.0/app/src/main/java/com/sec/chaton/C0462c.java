package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.c */
/* loaded from: classes.dex */
class C0462c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f1455a;

    C0462c(HomeActivity homeActivity) {
        this.f1455a = homeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(GlobalApplication.m3100a()).unregisterReceiver(this.f1455a.f251e);
        this.f1455a.f251e = null;
        Intent intent2 = new Intent(this.f1455a, (Class<?>) ExitAppDialogActivity.class);
        intent2.putExtra("reason", intent.getIntExtra("reason", 0));
        this.f1455a.startActivity(intent2);
    }
}
