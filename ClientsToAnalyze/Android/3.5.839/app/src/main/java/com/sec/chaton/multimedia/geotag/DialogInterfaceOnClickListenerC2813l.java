package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2813l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2811j f10165a;

    DialogInterfaceOnClickListenerC2813l(HandlerC2811j handlerC2811j) {
        this.f10165a = handlerC2811j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f10165a.f10163a.f10131e.show();
        this.f10165a.f10163a.m11730e();
        this.f10165a.f10163a.f10151y = false;
    }
}
