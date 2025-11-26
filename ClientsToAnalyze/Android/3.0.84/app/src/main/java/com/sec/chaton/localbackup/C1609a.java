package com.sec.chaton.localbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityBackupList.java */
/* renamed from: com.sec.chaton.localbackup.a */
/* loaded from: classes.dex */
class C1609a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityBackupList f5985a;

    C1609a(ActivityBackupList activityBackupList) {
        this.f5985a = activityBackupList;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), ActivityBackupList.f5939a);
        this.f5985a.m6786f();
    }
}
