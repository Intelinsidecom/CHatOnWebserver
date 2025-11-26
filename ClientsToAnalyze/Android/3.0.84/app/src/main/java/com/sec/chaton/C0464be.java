package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.common.CommonApplication;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.be */
/* loaded from: classes.dex */
class C0464be extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1532a;

    C0464be(TabActivity tabActivity) {
        this.f1532a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(CommonApplication.m11493l()).unregisterReceiver(this.f1532a.f786j);
        this.f1532a.f786j = null;
        Intent intent2 = new Intent(this.f1532a, (Class<?>) ExitAppDialogActivity.class);
        intent2.putExtra("reason", intent.getIntExtra("reason", 0));
        this.f1532a.startActivity(intent2);
    }
}
