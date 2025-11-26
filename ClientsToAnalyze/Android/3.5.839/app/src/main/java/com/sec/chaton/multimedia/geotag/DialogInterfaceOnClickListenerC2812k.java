package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2812k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2811j f10164a;

    DialogInterfaceOnClickListenerC2812k(HandlerC2811j handlerC2811j) {
        this.f10164a = handlerC2811j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f10164a.f10163a.finish();
    }
}
