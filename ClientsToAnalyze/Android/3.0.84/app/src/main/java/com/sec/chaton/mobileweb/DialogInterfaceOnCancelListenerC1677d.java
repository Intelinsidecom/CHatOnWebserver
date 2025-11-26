package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.d */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1677d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6180a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6181b;

    DialogInterfaceOnCancelListenerC1677d(C1673a c1673a, JsResult jsResult) {
        this.f6181b = c1673a;
        this.f6180a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f6180a.cancel();
    }
}
