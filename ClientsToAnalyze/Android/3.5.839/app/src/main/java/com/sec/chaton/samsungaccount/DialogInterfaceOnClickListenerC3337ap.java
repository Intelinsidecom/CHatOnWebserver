package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3337ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f12272a;

    /* renamed from: b */
    final /* synthetic */ C3336ao f12273b;

    DialogInterfaceOnClickListenerC3337ap(C3336ao c3336ao, JsResult jsResult) {
        this.f12273b = c3336ao;
        this.f12272a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12272a.confirm();
    }
}
