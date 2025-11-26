package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bk */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2349bk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f8801a;

    /* renamed from: b */
    final /* synthetic */ C2348bj f8802b;

    DialogInterfaceOnClickListenerC2349bk(C2348bj c2348bj, JsResult jsResult) {
        this.f8802b = c2348bj;
        this.f8801a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8801a.confirm();
    }
}
