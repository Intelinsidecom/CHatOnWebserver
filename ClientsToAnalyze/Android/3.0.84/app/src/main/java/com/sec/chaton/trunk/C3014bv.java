package com.sec.chaton.trunk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bv */
/* loaded from: classes.dex */
class C3014bv extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f10862a;

    C3014bv(TrunkPageActivity trunkPageActivity) {
        this.f10862a = trunkPageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceive : " + intent.getAction(), TrunkPageActivity.f10632f);
        }
        this.f10862a.m10355j();
    }
}
