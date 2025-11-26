package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2961af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2957ab f11053a;

    DialogInterfaceOnClickListenerC2961af(HandlerC2957ab handlerC2957ab) {
        this.f11053a = handlerC2957ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
