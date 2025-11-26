package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.i */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1777i implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6436a;

    DialogInterfaceOnDismissListenerC1777i(BlackScreenNotification blackScreenNotification) {
        this.f6436a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f6436a.finish();
    }
}
