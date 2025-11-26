package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1966af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7658a;

    DialogInterfaceOnClickListenerC1966af(HandlerC2034y handlerC2034y) {
        this.f7658a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
