package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4471ay implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16156a;

    DialogInterfaceOnCancelListenerC4471ay(DialogC4469aw dialogC4469aw) {
        this.f16156a = dialogC4469aw;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f16156a.f16147k.mo2271a();
        this.f16156a.dismiss();
    }
}
