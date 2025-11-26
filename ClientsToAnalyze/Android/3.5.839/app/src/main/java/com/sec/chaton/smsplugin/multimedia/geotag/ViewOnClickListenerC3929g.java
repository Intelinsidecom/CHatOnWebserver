package com.sec.chaton.smsplugin.multimedia.geotag;

import android.view.View;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC3929g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14157a;

    ViewOnClickListenerC3929g(MmsGeotagActivity mmsGeotagActivity) {
        this.f14157a = mmsGeotagActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14157a.f14131i != null) {
            if (this.f14157a.f14131i.zoomOut() && this.f14157a.f14130h != null) {
                C3890m.m14996b(MmsGeotagActivity.f14114b, "zoom level : " + this.f14157a.f14130h.getZoomLevel());
            }
            this.f14157a.m15171a();
        }
    }
}
