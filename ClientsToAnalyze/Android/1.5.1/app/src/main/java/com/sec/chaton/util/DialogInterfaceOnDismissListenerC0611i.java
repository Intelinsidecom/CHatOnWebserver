package com.sec.chaton.util;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.util.i */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0611i implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f3776a;

    DialogInterfaceOnDismissListenerC0611i(BlackScreenNotification blackScreenNotification) {
        this.f3776a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f3776a.finish();
    }
}
