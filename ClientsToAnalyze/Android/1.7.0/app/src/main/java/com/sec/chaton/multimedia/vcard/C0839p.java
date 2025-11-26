package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.p */
/* loaded from: classes.dex */
class C0839p extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f2919a;

    C0839p(VCardReadContactActivity vCardReadContactActivity) {
        this.f2919a = vCardReadContactActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), VCardReadContactActivity.f2836a);
        this.f2919a.m3376c();
    }
}
