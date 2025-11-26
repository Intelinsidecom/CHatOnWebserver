package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1758bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6396a;

    DialogInterfaceOnClickListenerC1758bn(ScreenOnNotification screenOnNotification) {
        this.f6396a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6396a.finish();
    }
}
