package com.sec.chaton.smsplugin.multimedia.geotag;

import android.view.View;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC3928f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14156a;

    ViewOnClickListenerC3928f(MmsGeotagActivity mmsGeotagActivity) {
        this.f14156a = mmsGeotagActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14156a.f14131i != null) {
            if (this.f14156a.f14131i.zoomIn() && this.f14156a.f14130h != null) {
                C3890m.m14996b(MmsGeotagActivity.f14114b, "zoom level : " + this.f14156a.f14130h.getZoomLevel());
            }
            this.f14156a.m15171a();
        }
    }
}
