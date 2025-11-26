package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2360h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f8815a;

    /* renamed from: b */
    final /* synthetic */ C2359g f8816b;

    DialogInterfaceOnClickListenerC2360h(C2359g c2359g, JsResult jsResult) {
        this.f8816b = c2359g;
        this.f8815a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8815a.confirm();
    }
}
