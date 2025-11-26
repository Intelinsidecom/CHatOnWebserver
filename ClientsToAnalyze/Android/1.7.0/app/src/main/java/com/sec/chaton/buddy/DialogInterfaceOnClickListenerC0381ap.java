package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0381ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0416bx f1350a;

    DialogInterfaceOnClickListenerC0381ap(HandlerC0416bx handlerC0416bx) {
        this.f1350a = handlerC0416bx;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1350a.f1391a.f1058A != null) {
            this.f1350a.f1391a.getActivity().finish();
        }
    }
}
