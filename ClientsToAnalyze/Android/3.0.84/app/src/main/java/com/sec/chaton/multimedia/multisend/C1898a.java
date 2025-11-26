package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: CategoryActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.a */
/* loaded from: classes.dex */
class C1898a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CategoryActivity f7233a;

    C1898a(CategoryActivity categoryActivity) {
        this.f7233a = categoryActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), CategoryActivity.f7189a);
        this.f7233a.m7719f();
    }
}
