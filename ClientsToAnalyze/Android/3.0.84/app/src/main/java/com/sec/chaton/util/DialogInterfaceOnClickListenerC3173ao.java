package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3173ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f11494a;

    DialogInterfaceOnClickListenerC3173ao(EnhancedNotification enhancedNotification) {
        this.f11494a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11494a.finish();
    }
}
