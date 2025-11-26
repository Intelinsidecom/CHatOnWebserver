package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC3338aq implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f12274a;

    /* renamed from: b */
    final /* synthetic */ C3336ao f12275b;

    DialogInterfaceOnDismissListenerC3338aq(C3336ao c3336ao, JsResult jsResult) {
        this.f12275b = c3336ao;
        this.f12274a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f12274a.cancel();
    }
}
