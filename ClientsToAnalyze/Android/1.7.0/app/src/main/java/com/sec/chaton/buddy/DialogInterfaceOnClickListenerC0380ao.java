package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0380ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f1348a;

    /* renamed from: b */
    final /* synthetic */ HandlerC0416bx f1349b;

    DialogInterfaceOnClickListenerC0380ao(HandlerC0416bx handlerC0416bx, boolean z) {
        this.f1349b = handlerC0416bx;
        this.f1348a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1349b.f1391a.m2070a(this.f1348a);
    }
}
