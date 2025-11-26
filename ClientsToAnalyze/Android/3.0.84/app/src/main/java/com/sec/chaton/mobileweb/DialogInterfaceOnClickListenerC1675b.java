package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1675b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6176a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6177b;

    DialogInterfaceOnClickListenerC1675b(C1673a c1673a, JsResult jsResult) {
        this.f6177b = c1673a;
        this.f6176a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6176a.cancel();
    }
}
