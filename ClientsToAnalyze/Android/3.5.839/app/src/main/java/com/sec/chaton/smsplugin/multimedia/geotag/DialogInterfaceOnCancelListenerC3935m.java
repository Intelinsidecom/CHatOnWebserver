package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.m */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3935m implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14163a;

    DialogInterfaceOnCancelListenerC3935m(MmsGeotagActivity mmsGeotagActivity) {
        this.f14163a = mmsGeotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f14163a.f14118D != null) {
            this.f14163a.f14118D.cancel(true);
        }
    }
}
