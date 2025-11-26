package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.content.Intent;

/* renamed from: com.sec.chaton.multimedia.geotag.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0303g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2173a;

    DialogInterfaceOnClickListenerC0303g(GeotagActivity geotagActivity) {
        this.f2173a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2173a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
    }
}
