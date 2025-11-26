package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3159aa;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bu */
/* loaded from: classes.dex */
class C0509bu extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1648a;

    C0509bu(TabActivity tabActivity) {
        this.f1648a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1648a.f797u = C3159aa.m10962a().m10978a("plus_tab_badge", (Integer) 0).intValue();
        this.f1648a.m1283l();
    }
}
