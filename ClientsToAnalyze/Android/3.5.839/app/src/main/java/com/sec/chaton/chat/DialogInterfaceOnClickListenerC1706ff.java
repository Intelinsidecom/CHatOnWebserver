package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2134o;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.ff */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1706ff implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1704fd f6311a;

    DialogInterfaceOnClickListenerC1706ff(HandlerC1704fd handlerC1704fd) {
        this.f6311a = handlerC1704fd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C2134o.m9569a(this.f6311a.f6309a.f5790ai, this.f6311a.f6309a.f5765J.getPath(), this.f6311a.f6309a.f5774S);
        if (this.f6311a.f6309a.f5772Q != null) {
            this.f6311a.f6309a.f5772Q.show();
        }
    }
}
