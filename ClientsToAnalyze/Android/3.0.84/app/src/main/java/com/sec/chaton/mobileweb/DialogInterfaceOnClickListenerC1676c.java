package com.sec.chaton.mobileweb;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1676c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f6178a;

    /* renamed from: b */
    final /* synthetic */ C1673a f6179b;

    DialogInterfaceOnClickListenerC1676c(C1673a c1673a, JsResult jsResult) {
        this.f6179b = c1673a;
        this.f6178a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6178a.confirm();
    }
}
