package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0805i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2737a;

    DialogInterfaceOnClickListenerC0805i(GeotagActivity geotagActivity) {
        this.f2737a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (!BuddyProfileActivity.m2254a(this.f2737a.f2708c, intent)) {
            intent = new Intent("android.settings.SETTINGS");
        }
        this.f2737a.startActivityForResult(intent, 0);
    }
}
