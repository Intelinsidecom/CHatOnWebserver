package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1414t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5049a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1409o f5050b;

    DialogInterfaceOnClickListenerC1414t(HandlerC1409o handlerC1409o, boolean z) {
        this.f5050b = handlerC1409o;
        this.f5049a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f5050b.f5043a.m6243a(this.f5049a);
    }
}
