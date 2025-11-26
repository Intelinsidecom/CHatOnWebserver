package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.f */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1679f implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6184a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6185b;

    DialogInterfaceOnDismissListenerC1679f(C1673a c1673a, JsResult jsResult) {
        this.f6185b = c1673a;
        this.f6184a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f6184a.cancel();
    }
}
