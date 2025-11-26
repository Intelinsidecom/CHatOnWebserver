package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1281ad implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4462a;

    DialogInterfaceOnDismissListenerC1281ad(BlackScreenNotification blackScreenNotification) {
        this.f4462a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f4462a.finish();
    }
}
