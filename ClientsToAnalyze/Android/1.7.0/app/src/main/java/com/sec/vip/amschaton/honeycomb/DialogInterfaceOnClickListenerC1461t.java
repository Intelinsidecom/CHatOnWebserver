package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1461t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgFrameSelectionActivity f5108a;

    DialogInterfaceOnClickListenerC1461t(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity) {
        this.f5108a = aMSBgFrameSelectionActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1001;
        if (i == 1) {
            i2 = 1000;
        }
        this.f5108a.m5013a(i2);
    }
}
