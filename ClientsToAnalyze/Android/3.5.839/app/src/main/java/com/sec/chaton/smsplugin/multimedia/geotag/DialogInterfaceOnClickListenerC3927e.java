package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3927e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3925c f14155a;

    DialogInterfaceOnClickListenerC3927e(HandlerC3925c handlerC3925c) {
        this.f14155a = handlerC3925c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14155a.f14153a.f14120F.show();
        this.f14155a.f14153a.m15157f();
        this.f14155a.f14153a.f14145w = false;
    }
}
