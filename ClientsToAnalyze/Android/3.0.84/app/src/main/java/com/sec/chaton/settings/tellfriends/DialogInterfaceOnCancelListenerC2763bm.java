package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2763bm implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10187a;

    DialogInterfaceOnCancelListenerC2763bm(DialogC2762bl dialogC2762bl) {
        this.f10187a = dialogC2762bl;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10187a.f10181m.stopLoading();
        this.f10187a.f10179k.mo539a();
    }
}
