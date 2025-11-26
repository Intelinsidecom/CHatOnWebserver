package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0339cx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0338cw f1482a;

    DialogInterfaceOnClickListenerC0339cx(HandlerC0338cw handlerC0338cw) {
        this.f1482a = handlerC0338cw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1482a.f1481a.getActivity().finish();
    }
}
