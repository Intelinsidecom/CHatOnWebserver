package com.facebook.p009c;

import android.content.DialogInterface;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.q */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0149q implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0147o f344a;

    DialogInterfaceOnCancelListenerC0149q(DialogC0147o dialogC0147o) {
        this.f344a = dialogC0147o;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f344a.m444a();
        this.f344a.dismiss();
    }
}
