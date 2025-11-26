package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0454s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0397be f1447a;

    DialogInterfaceOnClickListenerC0454s(HandlerC0397be handlerC0397be) {
        this.f1447a = handlerC0397be;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1447a.f1371a.finish();
    }
}
