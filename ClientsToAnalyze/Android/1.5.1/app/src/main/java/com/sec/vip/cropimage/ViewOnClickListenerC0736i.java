package com.sec.vip.cropimage;

import android.view.View;

/* renamed from: com.sec.vip.cropimage.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0736i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f4475a;

    ViewOnClickListenerC0736i(ImageModify imageModify) {
        this.f4475a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4475a.setResult(0);
        this.f4475a.finish();
    }
}
