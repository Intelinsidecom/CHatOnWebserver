package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2128i;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1707fg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1704fd f6312a;

    DialogInterfaceOnClickListenerC1707fg(HandlerC1704fd handlerC1704fd) {
        this.f6312a = handlerC1704fd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6312a.f6309a.f5772Q != null) {
            this.f6312a.f6309a.f5772Q.show();
        }
        new C2128i(this.f6312a.f6309a.f5790ai).m9508b(this.f6312a.f6309a.f5779X);
    }
}
