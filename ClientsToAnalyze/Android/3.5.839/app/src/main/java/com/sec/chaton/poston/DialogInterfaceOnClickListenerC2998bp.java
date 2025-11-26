package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2998bp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2995bm f11113a;

    DialogInterfaceOnClickListenerC2998bp(HandlerC2995bm handlerC2995bm) {
        this.f11113a = handlerC2995bm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
