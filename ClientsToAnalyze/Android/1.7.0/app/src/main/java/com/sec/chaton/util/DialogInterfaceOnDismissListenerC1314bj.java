package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1314bj implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4533a;

    DialogInterfaceOnDismissListenerC1314bj(ScreenOnNotification screenOnNotification) {
        this.f4533a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f4533a.finish();
    }
}
