package com.sec.chaton.multimedia.geotag;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1838c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6862a;

    ViewOnClickListenerC1838c(GeotagActivity geotagActivity) {
        this.f6862a = geotagActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6862a.f6842j != null) {
            if (this.f6862a.f6842j.zoomOut() && C3250y.f11734b && this.f6862a.f6841i != null) {
                C3250y.m11450b("zoom level : " + this.f6862a.f6841i.getZoomLevel(), GeotagActivity.f6826b);
            }
            this.f6862a.m7543a();
        }
    }
}
