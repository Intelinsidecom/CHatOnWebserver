package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.m */
/* loaded from: classes.dex */
class C2908m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f10770a;

    C2908m(VCardReadContactActivity vCardReadContactActivity) {
        this.f10770a = vCardReadContactActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), VCardReadContactActivity.class.getSimpleName());
        this.f10770a.m12076j();
    }
}
