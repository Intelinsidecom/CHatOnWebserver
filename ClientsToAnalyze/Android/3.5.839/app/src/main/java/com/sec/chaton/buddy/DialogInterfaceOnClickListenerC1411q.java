package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1411q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1409o f5045a;

    DialogInterfaceOnClickListenerC1411q(HandlerC1409o handlerC1409o) {
        this.f5045a = handlerC1409o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5045a.f5043a.f3528V.finish();
    }
}
