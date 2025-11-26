package com.sec.chaton.localbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityBackupList.java */
/* renamed from: com.sec.chaton.localbackup.a */
/* loaded from: classes.dex */
class C2509a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityBackupList f9027a;

    C2509a(ActivityBackupList activityBackupList) {
        this.f9027a = activityBackupList;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), ActivityBackupList.f8979n);
        this.f9027a.m10812k();
    }
}
