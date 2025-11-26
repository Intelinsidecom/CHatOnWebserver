package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.i */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1844i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6868a;

    DialogInterfaceOnCancelListenerC1844i(GeotagActivity geotagActivity) {
        this.f6868a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f6868a.f6832F != null) {
            this.f6868a.f6832F.cancel(true);
        }
    }
}
