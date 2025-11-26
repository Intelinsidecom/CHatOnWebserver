package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4745bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4740az f17409a;

    DialogInterfaceOnClickListenerC4745bd(HandlerC4740az handlerC4740az) {
        this.f17409a = handlerC4740az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
