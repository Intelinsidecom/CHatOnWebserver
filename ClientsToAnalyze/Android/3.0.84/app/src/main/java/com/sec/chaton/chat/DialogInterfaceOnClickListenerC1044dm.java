package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1335m;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1044dm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1042dk f4155a;

    DialogInterfaceOnClickListenerC1044dm(HandlerC1042dk handlerC1042dk) {
        this.f4155a = handlerC1042dk;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1335m.m5783a(this.f4155a.f4153a.f3733U, this.f4155a.f4153a.f3717E.getPath(), this.f4155a.f4153a.f3726N);
        if (this.f4155a.f4153a.f3724L != null) {
            this.f4155a.f4153a.f3724L.show();
        }
    }
}
