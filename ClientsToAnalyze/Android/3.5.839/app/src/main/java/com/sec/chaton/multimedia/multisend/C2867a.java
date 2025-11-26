package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: CategoryActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.a */
/* loaded from: classes.dex */
class C2867a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CategoryActivity f10554a;

    C2867a(CategoryActivity categoryActivity) {
        this.f10554a = categoryActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), CategoryActivity.f10510n);
        this.f10554a.m11950k();
    }
}
