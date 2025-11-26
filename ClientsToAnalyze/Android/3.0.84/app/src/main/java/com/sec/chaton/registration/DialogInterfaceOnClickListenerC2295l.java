package com.sec.chaton.registration;

import android.content.DialogInterface;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2295l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2291h f8600a;

    DialogInterfaceOnClickListenerC2295l(HandlerC2291h handlerC2291h) {
        this.f8600a = handlerC2291h;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8600a.f8596a.f8090b.m5721a(RtspHeaders.Values.APPEND);
    }
}
