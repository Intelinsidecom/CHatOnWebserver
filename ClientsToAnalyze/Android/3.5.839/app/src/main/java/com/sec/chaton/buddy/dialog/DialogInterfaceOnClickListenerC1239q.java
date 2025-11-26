package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1239q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4739a;

    DialogInterfaceOnClickListenerC1239q(HandlerC1238p handlerC1238p) {
        this.f4739a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4739a.f4738a.finish();
    }
}
