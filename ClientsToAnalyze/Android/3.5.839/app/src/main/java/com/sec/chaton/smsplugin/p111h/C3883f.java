package com.sec.chaton.smsplugin.p111h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.ServiceState;

/* compiled from: DownloadManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.f */
/* loaded from: classes.dex */
class C3883f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C3881d f13979a;

    C3883f(C3881d c3881d) {
        this.f13979a = c3881d;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SERVICE_STATE".equals(intent.getAction())) {
            boolean roaming = ServiceState.newFromBundle(intent.getExtras()).getRoaming();
            synchronized (C3881d.f13971g) {
                this.f13979a.f13975d = C3881d.m14967a(this.f13979a.f13974c, roaming);
            }
        }
    }
}
