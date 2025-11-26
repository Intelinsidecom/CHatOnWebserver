package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1242t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4742a;

    DialogInterfaceOnClickListenerC1242t(HandlerC1238p handlerC1238p) {
        this.f4742a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4742a.f4738a.finish();
    }
}
