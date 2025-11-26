package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.g */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2813g implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2811e f10334a;

    DialogInterfaceOnCancelListenerC2813g(DialogC2811e dialogC2811e) {
        this.f10334a = dialogC2811e;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10334a.f10327d.mo539a();
        this.f10334a.dismiss();
    }
}
