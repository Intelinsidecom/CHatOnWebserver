package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

/* renamed from: com.sec.chaton.multimedia.geotag.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0300d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2169a;

    DialogInterfaceOnClickListenerC0300d(GeotagActivity geotagActivity) {
        this.f2169a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GeoPoint geoPoint = new GeoPoint(37496705, 127026877);
        this.f2169a.f2158s = geoPoint;
        this.f2169a.f2159t = geoPoint;
        this.f2169a.f2153n.animateTo(geoPoint);
        this.f2169a.f2153n.setZoom(16);
        OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
        this.f2169a.f2157r.m2534b(overlayItem);
        this.f2169a.f2157r.m2533a(overlayItem);
        this.f2169a.f2156q.add(this.f2169a.f2157r);
    }
}
