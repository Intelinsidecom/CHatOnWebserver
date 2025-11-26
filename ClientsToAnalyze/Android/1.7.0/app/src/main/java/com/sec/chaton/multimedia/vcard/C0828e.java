package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: ReadVCardActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.e */
/* loaded from: classes.dex */
class C0828e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ReadVCardActivity f2873a;

    C0828e(ReadVCardActivity readVCardActivity) {
        this.f2873a = readVCardActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), ReadVCardActivity.f2824a);
        this.f2873a.m3363e();
    }
}
