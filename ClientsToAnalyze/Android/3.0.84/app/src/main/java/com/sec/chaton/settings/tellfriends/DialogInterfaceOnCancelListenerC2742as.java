package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.as */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2742as implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10139a;

    DialogInterfaceOnCancelListenerC2742as(DialogC2741ar dialogC2741ar) {
        this.f10139a = dialogC2741ar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10139a.f10134l.stopLoading();
        this.f10139a.f10132j.mo539a();
    }
}
