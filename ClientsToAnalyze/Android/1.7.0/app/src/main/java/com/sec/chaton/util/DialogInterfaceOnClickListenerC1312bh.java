package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1312bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4531a;

    DialogInterfaceOnClickListenerC1312bh(ScreenOnNotification screenOnNotification) {
        this.f4531a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4531a.finish();
    }
}
