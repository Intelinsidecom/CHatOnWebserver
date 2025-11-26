package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: VKontakteDialog.java */
/* renamed from: com.sec.chaton.sns.ui.as */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4465as implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4464ar f16133a;

    DialogInterfaceOnCancelListenerC4465as(DialogC4464ar dialogC4464ar) {
        this.f16133a = dialogC4464ar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16133a.f16129h.stopLoading();
        this.f16133a.f16127f.mo2271a();
    }
}
