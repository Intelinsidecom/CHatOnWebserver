package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: VKontakteDialog.java */
/* renamed from: com.sec.chaton.sns.ui.at */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4466at implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4464ar f16134a;

    DialogInterfaceOnCancelListenerC4466at(DialogC4464ar dialogC4464ar) {
        this.f16134a = dialogC4464ar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16134a.f16127f.mo2271a();
        this.f16134a.dismiss();
    }
}
