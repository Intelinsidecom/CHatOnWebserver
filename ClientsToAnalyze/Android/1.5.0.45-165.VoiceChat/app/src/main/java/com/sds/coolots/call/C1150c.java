package com.sds.coolots.call;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.sds.coolots.call.c */
/* loaded from: classes.dex */
class C1150c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C1134a f2354a;

    C1150c(C1134a c1134a) {
        this.f2354a = c1134a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1134a.m2109b("<CIH> minute minder alaramed!");
        new Thread(new RunnableC1172d(this)).start();
    }
}
