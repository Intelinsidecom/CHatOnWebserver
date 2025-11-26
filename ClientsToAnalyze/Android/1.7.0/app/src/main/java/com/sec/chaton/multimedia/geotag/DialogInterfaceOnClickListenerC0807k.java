package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0807k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0800d f2739a;

    DialogInterfaceOnClickListenerC0807k(HandlerC0800d handlerC0800d) {
        this.f2739a = handlerC0800d;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2739a.f2732a.f2727v.setButtonEnabled(false);
    }
}
