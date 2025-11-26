package com.sec.vip.cropimage;

import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC3613i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f13285a;

    ViewOnClickListenerC3613i(CropImage cropImage) {
        this.f13285a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13285a.f13158M) {
            this.f13285a.f13183v = view.getId();
            new AsyncTaskC3615k(this.f13285a, view, this.f13285a.f13176o).execute(new String[0]);
        }
    }
}
