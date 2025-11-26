package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3352bd implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3351bc f12290a;

    DialogInterfaceOnCancelListenerC3352bd(HandlerC3351bc handlerC3351bc) {
        this.f12290a = handlerC3351bc;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f12290a.f12289a.m13189z();
    }
}
