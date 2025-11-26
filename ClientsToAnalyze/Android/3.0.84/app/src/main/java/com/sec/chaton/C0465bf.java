package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bf */
/* loaded from: classes.dex */
class C0465bf extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1533a;

    C0465bf(TabActivity tabActivity) {
        this.f1533a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3250y.f11734b) {
            C3250y.m11450b("received Update Push Version", TabActivity.f732f);
        }
        if (this.f1533a.m1201D()) {
            this.f1533a.f747N = true;
            return;
        }
        Intent intent2 = new Intent(this.f1533a, (Class<?>) NewSPPUpgradeDialog.class);
        intent2.putExtra("isCritical", false);
        intent2.putExtra("isFromHome", true);
        intent2.setFlags(131072);
        this.f1533a.startActivity(intent2);
    }
}
