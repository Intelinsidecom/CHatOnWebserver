package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.cd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3379cd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f12335a;

    /* renamed from: b */
    final /* synthetic */ C3378cc f12336b;

    DialogInterfaceOnClickListenerC3379cd(C3378cc c3378cc, JsResult jsResult) {
        this.f12336b = c3378cc;
        this.f12335a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12335a.confirm();
    }
}
