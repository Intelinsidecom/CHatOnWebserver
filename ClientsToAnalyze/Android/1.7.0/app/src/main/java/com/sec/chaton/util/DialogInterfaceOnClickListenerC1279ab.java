package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1279ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4460a;

    DialogInterfaceOnClickListenerC1279ab(BlackScreenNotification blackScreenNotification) {
        this.f4460a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4460a.finish();
    }
}
