package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.i */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC2361i implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f8817a;

    /* renamed from: b */
    final /* synthetic */ C2359g f8818b;

    DialogInterfaceOnDismissListenerC2361i(C2359g c2359g, JsResult jsResult) {
        this.f8818b = c2359g;
        this.f8817a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f8817a.cancel();
    }
}
