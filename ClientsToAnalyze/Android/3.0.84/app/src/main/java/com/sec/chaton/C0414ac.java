package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.ac */
/* loaded from: classes.dex */
class C0414ac extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f1459a;

    C0414ac(PlusFragment plusFragment) {
        this.f1459a = plusFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f1459a.f710h != null) {
            this.f1459a.f710h.notifyDataSetChanged();
        }
        this.f1459a.m1181e();
    }
}
