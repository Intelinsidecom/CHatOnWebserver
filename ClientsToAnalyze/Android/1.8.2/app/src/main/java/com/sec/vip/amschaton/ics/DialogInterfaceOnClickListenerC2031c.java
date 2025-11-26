package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2031c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgFrameSelectionActivity f7319a;

    DialogInterfaceOnClickListenerC2031c(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity) {
        this.f7319a = aMSBgFrameSelectionActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1001;
        if (i == 1) {
            i2 = 1000;
        }
        this.f7319a.m6861a(i2);
    }
}
