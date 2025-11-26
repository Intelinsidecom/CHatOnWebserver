package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2128i;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1476g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1475f f5359a;

    DialogInterfaceOnClickListenerC1476g(HandlerC1475f handlerC1475f) {
        this.f5359a = handlerC1475f;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5359a.f5358a.m7702t();
        new C2128i(this.f5359a.f5358a.f5215b).m9508b(this.f5359a.f5358a.f5211L.m7046a());
    }
}
