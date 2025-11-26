package com.sec.chaton.util;

import android.content.DialogInterface;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1775g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6434a;

    DialogInterfaceOnClickListenerC1775g(BlackScreenNotification blackScreenNotification) {
        this.f6434a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6434a.finish();
    }
}
