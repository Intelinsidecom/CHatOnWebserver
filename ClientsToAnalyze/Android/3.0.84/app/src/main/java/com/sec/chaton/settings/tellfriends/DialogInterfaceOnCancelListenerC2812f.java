package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.f */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2812f implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2811e f10333a;

    DialogInterfaceOnCancelListenerC2812f(DialogC2811e dialogC2811e) {
        this.f10333a = dialogC2811e;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10333a.f10329f.stopLoading();
        this.f10333a.f10327d.mo539a();
    }
}
