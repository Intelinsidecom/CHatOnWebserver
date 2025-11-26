package com.sec.vip.cropimage.ics;

import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC2100a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7660a;

    ViewOnClickListenerC2100a(CropImage cropImage) {
        this.f7660a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7660a.setResult(0);
        this.f7660a.finish();
    }
}
