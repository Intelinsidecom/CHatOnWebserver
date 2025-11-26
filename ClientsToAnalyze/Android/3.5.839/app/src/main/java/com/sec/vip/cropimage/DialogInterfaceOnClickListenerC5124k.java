package com.sec.vip.cropimage;

import android.content.DialogInterface;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC5124k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC5123j f18697a;

    DialogInterfaceOnClickListenerC5124k(HandlerC5123j handlerC5123j) {
        this.f18697a = handlerC5123j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f18697a.f18696a.setResult(0, this.f18697a.f18696a.f18623P);
        this.f18697a.f18696a.finish();
    }
}
