package com.sec.chaton.poston;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1991bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7706a;

    ViewOnClickListenerC1991bd(PostONWriteFragment postONWriteFragment) {
        this.f7706a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7706a.f7575A == null || this.f7706a.f7575A.length() == 0) {
            if (C3250y.f11733a) {
                C3250y.m11456e("mLocationData null", "PostONWriteFragment");
            }
            this.f7706a.m7986a(this.f7706a.f7630v, false);
            Intent intent = new Intent(this.f7706a.getActivity(), (Class<?>) GeotagActivity.class);
            intent.putExtra("sendbutton", false);
            this.f7706a.startActivityForResult(intent, 7);
            return;
        }
        if (C3250y.f11733a) {
            C3250y.m11456e("mLocationButton Click", "PostONWriteFragment");
        }
        if (this.f7706a.f7632x.getVisibility() == 8) {
            this.f7706a.f7631w.setVisibility(0);
            this.f7706a.f7595U.setVisibility(8);
            this.f7706a.f7632x.setVisibility(0);
        } else if (this.f7706a.f7631w.getVisibility() == 0) {
            this.f7706a.f7632x.setVisibility(8);
        } else {
            this.f7706a.f7631w.setVisibility(0);
            this.f7706a.f7595U.setVisibility(8);
        }
        this.f7706a.m7986a(this.f7706a.f7630v, false);
    }
}
