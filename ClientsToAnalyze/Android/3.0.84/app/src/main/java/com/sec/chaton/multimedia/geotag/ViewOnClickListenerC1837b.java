package com.sec.chaton.multimedia.geotag;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1837b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6861a;

    ViewOnClickListenerC1837b(GeotagActivity geotagActivity) {
        this.f6861a = geotagActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6861a.f6842j != null) {
            if (this.f6861a.f6842j.zoomIn() && C3250y.f11734b && this.f6861a.f6841i != null) {
                C3250y.m11450b("zoom level : " + this.f6861a.f6841i.getZoomLevel(), GeotagActivity.f6826b);
            }
            this.f6861a.m7543a();
        }
    }
}
