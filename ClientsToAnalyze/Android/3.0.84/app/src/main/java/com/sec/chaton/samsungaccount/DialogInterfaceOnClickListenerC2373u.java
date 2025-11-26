package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.res.Resources;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2373u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2371s f8831a;

    DialogInterfaceOnClickListenerC2373u(HandlerC2371s handlerC2371s) {
        this.f8831a = handlerC2371s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException, UnsupportedEncodingException {
        this.f8831a.f8829a.f8666Q = true;
        if (this.f8831a.f8829a.f8665P) {
            this.f8831a.f8829a.m8777f();
        } else {
            this.f8831a.f8829a.m8765c(true);
        }
    }
}
