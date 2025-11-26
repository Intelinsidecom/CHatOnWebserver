package com.sec.vip.amschaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSActivity.java */
/* renamed from: com.sec.vip.amschaton.a */
/* loaded from: classes.dex */
class C3392a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AMSActivity f12429a;

    C3392a(AMSActivity aMSActivity) {
        this.f12429a = aMSActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("[onReceive] Storage: " + intent.getData(), getClass().getSimpleName());
        this.f12429a.m11966g();
    }
}
