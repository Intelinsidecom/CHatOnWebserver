package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2958ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2957ab f11050a;

    DialogInterfaceOnClickListenerC2958ac(HandlerC2957ab handlerC2957ab) {
        this.f11050a = handlerC2957ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11050a.f11049a.f10906U.m9300d(this.f11050a.f11049a.f10890E, this.f11050a.f11049a.f10896K);
        dialogInterface.dismiss();
    }
}
