package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.i */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2810i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10162a;

    DialogInterfaceOnCancelListenerC2810i(GeotagActivity geotagActivity) {
        this.f10162a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f10162a.f10127F != null) {
            this.f10162a.f10127F.cancel(true);
        }
    }
}
