package com.sec.vip.amschaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSActivity.java */
/* renamed from: com.sec.vip.amschaton.d */
/* loaded from: classes.dex */
class C1399d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AMSActivity f4920a;

    C1399d(AMSActivity aMSActivity) {
        this.f4920a = aMSActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("[onReceive] Storage: " + intent.getData(), getClass().getSimpleName());
        this.f4920a.m4733h();
    }
}
