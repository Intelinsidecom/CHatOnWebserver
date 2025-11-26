package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bl */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC2350bl implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f8803a;

    /* renamed from: b */
    final /* synthetic */ C2348bj f8804b;

    DialogInterfaceOnDismissListenerC2350bl(C2348bj c2348bj, JsResult jsResult) {
        this.f8804b = c2348bj;
        this.f8803a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f8803a.cancel();
    }
}
