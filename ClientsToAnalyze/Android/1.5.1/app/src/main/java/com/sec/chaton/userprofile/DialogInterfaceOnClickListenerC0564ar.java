package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.userprofile.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0564ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0594r f3543a;

    DialogInterfaceOnClickListenerC0564ar(ViewOnClickListenerC0594r viewOnClickListenerC0594r) {
        this.f3543a = viewOnClickListenerC0594r;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
