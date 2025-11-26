package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1678e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6182a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6183b;

    DialogInterfaceOnClickListenerC1678e(C1673a c1673a, JsResult jsResult) {
        this.f6183b = c1673a;
        this.f6182a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6182a.confirm();
    }
}
