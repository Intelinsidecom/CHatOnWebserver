package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3926d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3925c f14154a;

    DialogInterfaceOnClickListenerC3926d(HandlerC3925c handlerC3925c) {
        this.f14154a = handlerC3925c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14154a.f14153a.finish();
    }
}
