package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1847l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1845j f6871a;

    DialogInterfaceOnClickListenerC1847l(HandlerC1845j handlerC1845j) {
        this.f6871a = handlerC1845j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6871a.f6869a.f6837e.show();
        this.f6871a.f6869a.m7524e();
        this.f6871a.f6869a.f6857y = false;
    }
}
