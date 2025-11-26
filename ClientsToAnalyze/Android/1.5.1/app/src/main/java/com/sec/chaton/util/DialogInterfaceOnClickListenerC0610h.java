package com.sec.chaton.util;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.util.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0610h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f3775a;

    DialogInterfaceOnClickListenerC0610h(EnhancedNotification enhancedNotification) {
        this.f3775a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3775a.finish();
    }
}
