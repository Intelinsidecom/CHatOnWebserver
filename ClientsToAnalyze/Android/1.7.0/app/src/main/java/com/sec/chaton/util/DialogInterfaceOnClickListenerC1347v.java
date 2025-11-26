package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1347v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f4588a;

    DialogInterfaceOnClickListenerC1347v(EnhancedNotification enhancedNotification) {
        this.f4588a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4588a.finish();
    }
}
