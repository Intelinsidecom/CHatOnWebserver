package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC0709l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f4339a;

    /* renamed from: b */
    final /* synthetic */ ZoomableImageView f4340b;

    ViewOnClickListenerC0709l(ZoomableImageView zoomableImageView, int i) {
        this.f4340b = zoomableImageView;
        this.f4339a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4340b.f4203I.removeCallbacks(this.f4340b.f4206L);
        this.f4340b.m4206a(this.f4339a);
        this.f4340b.f4203I.postDelayed(this.f4340b.f4206L, 2000L);
    }
}
