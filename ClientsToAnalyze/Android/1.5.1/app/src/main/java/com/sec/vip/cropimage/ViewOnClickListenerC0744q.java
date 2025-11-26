package com.sec.vip.cropimage;

import android.view.View;

/* renamed from: com.sec.vip.cropimage.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC0744q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f4510a;

    ViewOnClickListenerC0744q(CropImage cropImage) {
        this.f4510a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4510a.setResult(0);
        this.f4510a.finish();
    }
}
