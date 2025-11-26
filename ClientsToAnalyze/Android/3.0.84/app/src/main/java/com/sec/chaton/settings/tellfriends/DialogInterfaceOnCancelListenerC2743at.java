package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.at */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2743at implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10140a;

    DialogInterfaceOnCancelListenerC2743at(DialogC2741ar dialogC2741ar) {
        this.f10140a = dialogC2741ar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10140a.f10132j.mo539a();
        this.f10140a.dismiss();
    }
}
