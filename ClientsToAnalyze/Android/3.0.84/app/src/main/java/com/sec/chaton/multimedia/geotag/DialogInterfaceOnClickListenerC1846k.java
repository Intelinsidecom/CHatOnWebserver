package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1846k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1845j f6870a;

    DialogInterfaceOnClickListenerC1846k(HandlerC1845j handlerC1845j) {
        this.f6870a = handlerC1845j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6870a.f6869a.finish();
    }
}
