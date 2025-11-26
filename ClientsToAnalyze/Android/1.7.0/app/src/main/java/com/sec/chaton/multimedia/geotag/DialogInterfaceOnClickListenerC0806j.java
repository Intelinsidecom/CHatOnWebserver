package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.Criteria;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0806j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0800d f2738a;

    DialogInterfaceOnClickListenerC0806j(HandlerC0800d handlerC0800d) {
        this.f2738a = handlerC0800d;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2738a.f2732a.f2710e.show();
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        this.f2738a.f2732a.f2718m = this.f2738a.f2732a.f2717l.getBestProvider(criteria, true);
        this.f2738a.f2732a.m3295a();
    }
}
