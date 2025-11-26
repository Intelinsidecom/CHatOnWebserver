package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4743bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4740az f17407a;

    DialogInterfaceOnClickListenerC4743bb(HandlerC4740az handlerC4740az) {
        this.f17407a = handlerC4740az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
