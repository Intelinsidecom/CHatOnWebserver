package com.sec.chaton.trunk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.by */
/* loaded from: classes.dex */
class C4633by extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16810a;

    C4633by(TrunkPageActivity trunkPageActivity) {
        this.f16810a = trunkPageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceive : " + intent.getAction(), TrunkPageActivity.f16577s);
        }
        this.f16810a.m17454k();
    }
}
