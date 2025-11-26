package com.sec.chaton.settings;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.settings.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0499j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0465an f3191a;

    DialogInterfaceOnClickListenerC0499j(ViewOnClickListenerC0465an viewOnClickListenerC0465an) {
        this.f3191a = viewOnClickListenerC0465an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
