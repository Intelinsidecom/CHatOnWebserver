package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1842g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6866a;

    DialogInterfaceOnClickListenerC1842g(GeotagActivity geotagActivity) {
        this.f6866a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (!BuddyProfileActivity.m3573a(this.f6866a.f6835c, intent)) {
            intent = new Intent("android.settings.SETTINGS");
        }
        this.f6866a.startActivityForResult(intent, 0);
    }
}
