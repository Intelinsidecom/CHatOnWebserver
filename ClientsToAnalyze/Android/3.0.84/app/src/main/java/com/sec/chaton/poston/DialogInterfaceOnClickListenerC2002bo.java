package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2002bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1999bl f7717a;

    DialogInterfaceOnClickListenerC2002bo(HandlerC1999bl handlerC1999bl) {
        this.f7717a = handlerC1999bl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
