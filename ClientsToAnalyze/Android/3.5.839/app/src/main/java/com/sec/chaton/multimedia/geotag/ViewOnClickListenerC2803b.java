package com.sec.chaton.multimedia.geotag;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC2803b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10155a;

    ViewOnClickListenerC2803b(GeotagActivity geotagActivity) {
        this.f10155a = geotagActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10155a.f10136j != null) {
            if (this.f10155a.f10136j.zoomIn() && C4904y.f17872b && this.f10155a.f10135i != null) {
                C4904y.m18639b("zoom level : " + this.f10155a.f10135i.getZoomLevel(), GeotagActivity.f10121b);
            }
            this.f10155a.m11748a();
        }
    }
}
