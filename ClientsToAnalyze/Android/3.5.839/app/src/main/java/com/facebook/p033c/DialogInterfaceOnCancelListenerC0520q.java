package com.facebook.p033c;

import android.content.DialogInterface;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.q */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0520q implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0518o f1314a;

    DialogInterfaceOnCancelListenerC0520q(DialogC0518o dialogC0518o) {
        this.f1314a = dialogC0518o;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1314a.m1887a();
        this.f1314a.dismiss();
    }
}
