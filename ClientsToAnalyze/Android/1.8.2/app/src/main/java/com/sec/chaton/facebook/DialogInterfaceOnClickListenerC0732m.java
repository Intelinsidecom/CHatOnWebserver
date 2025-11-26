package com.sec.chaton.facebook;

import android.content.DialogInterface;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0732m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0729j f2721a;

    /* renamed from: b */
    final /* synthetic */ AbstractC0728i f2722b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0728i f2723c;

    /* renamed from: d */
    final /* synthetic */ C0731l f2724d;

    DialogInterfaceOnClickListenerC0732m(C0731l c0731l, AsyncTaskC0729j asyncTaskC0729j, AbstractC0728i abstractC0728i, AbstractC0728i abstractC0728i2) {
        this.f2724d = c0731l;
        this.f2721a = asyncTaskC0729j;
        this.f2722b = abstractC0728i;
        this.f2723c = abstractC0728i2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2721a.execute(this.f2722b, this.f2723c);
    }
}
