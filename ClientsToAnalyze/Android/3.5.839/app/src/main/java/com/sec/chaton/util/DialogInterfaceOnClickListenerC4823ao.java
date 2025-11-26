package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4823ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f17609a;

    DialogInterfaceOnClickListenerC4823ao(EnhancedNotification enhancedNotification) {
        this.f17609a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17609a.finish();
    }
}
