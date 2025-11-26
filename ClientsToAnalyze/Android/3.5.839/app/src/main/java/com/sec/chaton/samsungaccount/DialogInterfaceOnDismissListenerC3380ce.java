package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.ce */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC3380ce implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f12337a;

    /* renamed from: b */
    final /* synthetic */ C3378cc f12338b;

    DialogInterfaceOnDismissListenerC3380ce(C3378cc c3378cc, JsResult jsResult) {
        this.f12338b = c3378cc;
        this.f12337a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f12337a.cancel();
    }
}
