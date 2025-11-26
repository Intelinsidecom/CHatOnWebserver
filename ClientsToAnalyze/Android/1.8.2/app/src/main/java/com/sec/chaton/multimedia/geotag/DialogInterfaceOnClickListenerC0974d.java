package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.Criteria;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0974d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0973c f3593a;

    DialogInterfaceOnClickListenerC0974d(HandlerC0973c handlerC0973c) {
        this.f3593a = handlerC0973c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3593a.f3592a.f3571i.show();
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        this.f3593a.f3592a.f3579q = this.f3593a.f3592a.f3578p.getBestProvider(criteria, true);
        this.f3593a.f3592a.m3851a();
    }
}
