package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2808g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10160a;

    DialogInterfaceOnClickListenerC2808g(GeotagActivity geotagActivity) {
        this.f10160a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (!BuddyProfileActivity.m6743a(this.f10160a.f10129c, intent)) {
            intent = new Intent("android.settings.SETTINGS");
        }
        this.f10160a.startActivityForResult(intent, 0);
    }
}
