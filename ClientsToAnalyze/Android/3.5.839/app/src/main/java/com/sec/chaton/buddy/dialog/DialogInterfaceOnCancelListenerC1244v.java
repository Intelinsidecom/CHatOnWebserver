package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.v */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1244v implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4744a;

    DialogInterfaceOnCancelListenerC1244v(HandlerC1238p handlerC1238p) {
        this.f4744a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4744a.f4738a.finish();
    }
}
