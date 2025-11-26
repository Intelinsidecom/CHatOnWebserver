package com.sec.chaton.registration;

import android.content.DialogInterface;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fe */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2262fe implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8558a;

    DialogInterfaceOnClickListenerC2262fe(HandlerC2249es handlerC2249es) {
        this.f8558a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8558a.f8544a.f8325m.m5721a(RtspHeaders.Values.APPEND);
    }
}
