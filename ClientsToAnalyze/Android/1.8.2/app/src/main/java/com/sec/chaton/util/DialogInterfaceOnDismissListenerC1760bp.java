package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1760bp implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6398a;

    DialogInterfaceOnDismissListenerC1760bp(ScreenOnNotification screenOnNotification) {
        this.f6398a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f6398a.finish();
    }
}
