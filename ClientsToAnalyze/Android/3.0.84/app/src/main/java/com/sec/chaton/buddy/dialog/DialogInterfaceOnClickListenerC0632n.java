package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0632n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0631m f2852a;

    DialogInterfaceOnClickListenerC0632n(HandlerC0631m handlerC0631m) {
        this.f2852a = handlerC0631m;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2852a.f2851a.finish();
    }
}
