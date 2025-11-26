package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3933k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14161a;

    DialogInterfaceOnClickListenerC3933k(MmsGeotagActivity mmsGeotagActivity) {
        this.f14161a = mmsGeotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14161a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
    }
}
