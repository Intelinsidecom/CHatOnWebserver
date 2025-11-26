package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.e */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2806e implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10158a;

    DialogInterfaceOnCancelListenerC2806e(GeotagActivity geotagActivity) {
        this.f10158a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f10158a.finish();
    }
}
