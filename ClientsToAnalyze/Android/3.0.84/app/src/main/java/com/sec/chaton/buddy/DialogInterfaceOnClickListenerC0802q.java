package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0802q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0801p f3097a;

    DialogInterfaceOnClickListenerC0802q(HandlerC0801p handlerC0801p) {
        this.f3097a = handlerC0801p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3097a.f3096a.f1669Q != null) {
            this.f3097a.f3096a.f1676X.finish();
        }
    }
}
