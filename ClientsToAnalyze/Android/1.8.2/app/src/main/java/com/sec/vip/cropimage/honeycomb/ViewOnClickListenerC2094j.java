package com.sec.vip.cropimage.honeycomb;

import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC2094j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7618a;

    ViewOnClickListenerC2094j(CropImage cropImage) {
        this.f7618a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7618a.setResult(0);
        this.f7618a.finish();
    }
}
