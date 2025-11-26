package com.sec.vip.amschaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1786r;

/* compiled from: AMSActivity.java */
/* renamed from: com.sec.vip.amschaton.d */
/* loaded from: classes.dex */
class C1887d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AMSActivity f6888a;

    C1887d(AMSActivity aMSActivity) {
        this.f6888a = aMSActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("[onReceive] Storage: " + intent.getData(), getClass().getSimpleName());
        this.f6888a.m6256i();
    }
}
