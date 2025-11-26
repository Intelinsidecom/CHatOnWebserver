package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4809aa;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.eh */
/* loaded from: classes.dex */
class C2314eh extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8237a;

    C2314eh(TabActivity tabActivity) {
        this.f8237a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8237a.f2041J = this.f8237a.m3071u();
        this.f8237a.m3061o();
        if ("promotion_event_update".equals(intent.getAction())) {
            C4809aa.m18104a().m18125b("pluslist_polling_recieve", (Boolean) true);
        }
    }
}
