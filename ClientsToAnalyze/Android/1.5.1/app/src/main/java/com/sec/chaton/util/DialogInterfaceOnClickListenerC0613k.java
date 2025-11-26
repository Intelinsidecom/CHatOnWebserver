package com.sec.chaton.util;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.util.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0613k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f3778a;

    DialogInterfaceOnClickListenerC0613k(BlackScreenNotification blackScreenNotification) {
        this.f3778a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3778a.finish();
    }
}
