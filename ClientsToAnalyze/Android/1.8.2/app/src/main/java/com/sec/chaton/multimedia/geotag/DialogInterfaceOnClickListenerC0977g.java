package com.sec.chaton.multimedia.geotag;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.util.C1786r;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0977g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3596a;

    DialogInterfaceOnClickListenerC0977g(GeotagActivity geotagActivity) {
        this.f3596a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f3596a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
        } catch (ActivityNotFoundException e) {
            C1786r.m6054a("No activity found for the intent", GeotagActivity.f3561a);
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }
}
