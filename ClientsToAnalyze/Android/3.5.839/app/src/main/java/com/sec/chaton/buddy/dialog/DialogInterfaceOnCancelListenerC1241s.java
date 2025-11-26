package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.s */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1241s implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4741a;

    DialogInterfaceOnCancelListenerC1241s(HandlerC1238p handlerC1238p) {
        this.f4741a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4741a.f4738a.finish();
    }
}
