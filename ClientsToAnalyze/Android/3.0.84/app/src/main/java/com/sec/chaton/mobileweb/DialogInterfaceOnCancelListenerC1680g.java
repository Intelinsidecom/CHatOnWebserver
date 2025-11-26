package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.g */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1680g implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6186a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6187b;

    DialogInterfaceOnCancelListenerC1680g(C1673a c1673a, JsResult jsResult) {
        this.f6187b = c1673a;
        this.f6186a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f6186a.cancel();
    }
}
