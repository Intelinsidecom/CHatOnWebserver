package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ReadVCardActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.h */
/* loaded from: classes.dex */
class C2903h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ReadVCardActivity f10752a;

    C2903h(ReadVCardActivity readVCardActivity) {
        this.f10752a = readVCardActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), ReadVCardActivity.class.getSimpleName());
        this.f10752a.m12065j();
    }
}
