package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1413s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1409o f5048a;

    DialogInterfaceOnClickListenerC1413s(HandlerC1409o handlerC1409o) {
        this.f5048a = handlerC1409o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5048a.f5043a.f3528V.finish();
    }
}
