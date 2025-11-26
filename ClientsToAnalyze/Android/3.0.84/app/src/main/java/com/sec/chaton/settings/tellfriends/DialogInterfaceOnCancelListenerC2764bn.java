package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2764bn implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10188a;

    DialogInterfaceOnCancelListenerC2764bn(DialogC2762bl dialogC2762bl) {
        this.f10188a = dialogC2762bl;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10188a.f10179k.mo539a();
        this.f10188a.dismiss();
    }
}
