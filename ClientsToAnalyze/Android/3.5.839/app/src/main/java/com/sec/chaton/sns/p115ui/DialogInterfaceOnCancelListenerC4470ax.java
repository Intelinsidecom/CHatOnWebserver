package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ax */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4470ax implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16155a;

    DialogInterfaceOnCancelListenerC4470ax(DialogC4469aw dialogC4469aw) {
        this.f16155a = dialogC4469aw;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16155a.f16149m.stopLoading();
        this.f16155a.f16147k.mo2271a();
    }
}
