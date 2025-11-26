package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.i */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3931i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14159a;

    DialogInterfaceOnCancelListenerC3931i(MmsGeotagActivity mmsGeotagActivity) {
        this.f14159a = mmsGeotagActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f14159a.finish();
    }
}
