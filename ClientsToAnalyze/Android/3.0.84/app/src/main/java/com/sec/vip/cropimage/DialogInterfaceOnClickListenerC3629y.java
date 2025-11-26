package com.sec.vip.cropimage;

import android.content.DialogInterface;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3629y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3628x f13339a;

    DialogInterfaceOnClickListenerC3629y(HandlerC3628x handlerC3628x) {
        this.f13339a = handlerC3628x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f13339a.f13338a.setResult(0, this.f13339a.f13338a.f13199D);
        this.f13339a.f13338a.finish();
    }
}
