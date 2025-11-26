package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1946c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgFrameSelectionActivity f7090a;

    DialogInterfaceOnClickListenerC1946c(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity) {
        this.f7090a = aMSBgFrameSelectionActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1001;
        if (i == 1) {
            i2 = 1000;
        }
        this.f7090a.m6539b(i2);
    }
}
