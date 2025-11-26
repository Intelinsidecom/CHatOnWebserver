package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.e */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1840e implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6864a;

    DialogInterfaceOnCancelListenerC1840e(GeotagActivity geotagActivity) {
        this.f6864a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f6864a.finish();
    }
}
