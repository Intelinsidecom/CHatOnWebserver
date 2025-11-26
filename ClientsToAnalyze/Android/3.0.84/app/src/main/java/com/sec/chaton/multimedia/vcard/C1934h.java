package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: ReadVCardActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.h */
/* loaded from: classes.dex */
class C1934h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ReadVCardActivity f7431a;

    C1934h(ReadVCardActivity readVCardActivity) {
        this.f7431a = readVCardActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), ReadVCardActivity.class.getSimpleName());
        this.f7431a.m7836e();
    }
}
