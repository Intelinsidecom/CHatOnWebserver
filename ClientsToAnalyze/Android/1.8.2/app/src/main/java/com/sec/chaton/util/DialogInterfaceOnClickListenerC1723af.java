package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1723af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f6318a;

    DialogInterfaceOnClickListenerC1723af(EnhancedNotification enhancedNotification) {
        this.f6318a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6318a.finish();
    }
}
