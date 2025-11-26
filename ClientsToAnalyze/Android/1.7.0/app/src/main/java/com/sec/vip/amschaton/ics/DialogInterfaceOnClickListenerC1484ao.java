package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1484ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgFrameSelectionActivity f5298a;

    DialogInterfaceOnClickListenerC1484ao(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity) {
        this.f5298a = aMSBgFrameSelectionActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1001;
        if (i == 1) {
            i2 = 1000;
        }
        this.f5298a.m5314a(i2);
    }
}
