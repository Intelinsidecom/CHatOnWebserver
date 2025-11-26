package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2128i;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1175cl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1174ck f4402a;

    DialogInterfaceOnClickListenerC1175cl(HandlerC1174ck handlerC1174ck) {
        this.f4402a = handlerC1174ck;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4402a.f4401a.m6326V();
        new C2128i(this.f4402a.f4401a.f3769v).m9508b(this.f4402a.f4401a.f3671az.m7046a());
    }
}
