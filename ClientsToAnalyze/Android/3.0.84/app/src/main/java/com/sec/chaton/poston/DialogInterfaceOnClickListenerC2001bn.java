package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2001bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1999bl f7716a;

    DialogInterfaceOnClickListenerC2001bn(HandlerC1999bl handlerC1999bl) {
        this.f7716a = handlerC1999bl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
