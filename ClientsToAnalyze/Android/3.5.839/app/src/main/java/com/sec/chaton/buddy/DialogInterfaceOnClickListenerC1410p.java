package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1410p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1409o f5044a;

    DialogInterfaceOnClickListenerC1410p(HandlerC1409o handlerC1409o) {
        this.f5044a = handlerC1409o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5044a.f5043a.f3521O != null) {
            this.f5044a.f5043a.f3528V.finish();
        }
    }
}
