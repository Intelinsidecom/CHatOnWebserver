package com.sec.vip.cropimage;

import android.view.View;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC1593j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f5613a;

    ViewOnClickListenerC1593j(ImageModify imageModify) {
        this.f5613a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5613a.setResult(0);
        this.f5613a.finish();
    }
}
