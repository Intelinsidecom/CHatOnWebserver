package com.sec.vip.cropimage.ics;

import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC1585g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f5602a;

    ViewOnClickListenerC1585g(CropImage cropImage) {
        this.f5602a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5602a.setResult(0);
        this.f5602a.finish();
    }
}
