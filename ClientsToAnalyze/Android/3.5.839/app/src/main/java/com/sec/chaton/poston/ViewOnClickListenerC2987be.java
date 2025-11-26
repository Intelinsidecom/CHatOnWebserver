package com.sec.chaton.poston;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC2987be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11102a;

    ViewOnClickListenerC2987be(PostONWriteFragment postONWriteFragment) {
        this.f11102a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11102a.f10970B == null || this.f11102a.f10970B.length() == 0) {
            if (C4904y.f17871a) {
                C4904y.m18646e("mLocationData null", "PostONWriteFragment");
            }
            this.f11102a.m12299a(this.f11102a.f11028w, false);
            this.f11102a.startActivityForResult(new Intent(this.f11102a.getActivity(), (Class<?>) GeotagActivity.class), 7);
            return;
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("mLocationButton Click", "PostONWriteFragment");
        }
        if (this.f11102a.f11030y.getVisibility() == 8) {
            this.f11102a.f11029x.setVisibility(0);
            this.f11102a.f10991W.setVisibility(8);
            this.f11102a.f11030y.setVisibility(0);
        } else if (this.f11102a.f11029x.getVisibility() == 0) {
            this.f11102a.f11030y.setVisibility(8);
        } else {
            this.f11102a.f11029x.setVisibility(0);
            this.f11102a.f10991W.setVisibility(8);
        }
        this.f11102a.m12299a(this.f11102a.f11028w, false);
    }
}
