package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.m */
/* loaded from: classes.dex */
class C1939m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f7449a;

    C1939m(VCardReadContactActivity vCardReadContactActivity) {
        this.f7449a = vCardReadContactActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), VCardReadContactActivity.class.getSimpleName());
        this.f7449a.m7848e();
    }
}
