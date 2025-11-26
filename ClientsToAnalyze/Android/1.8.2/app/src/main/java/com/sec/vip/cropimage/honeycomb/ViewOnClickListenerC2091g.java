package com.sec.vip.cropimage.honeycomb;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC2091g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7614a;

    ViewOnClickListenerC2091g(CropImage cropImage) {
        this.f7614a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_template_rect /* 2131492968 */:
                this.f7614a.f7594r = 1000;
                this.f7614a.m7347a(false);
                break;
            case R.id.iv_template_roundrect /* 2131492969 */:
                this.f7614a.f7594r = 1001;
                this.f7614a.m7347a(false);
                break;
            case R.id.iv_template_circle /* 2131492970 */:
                this.f7614a.f7594r = 1002;
                this.f7614a.m7347a(false);
                break;
            case R.id.iv_template_star /* 2131492971 */:
                this.f7614a.f7594r = 1003;
                this.f7614a.m7347a(false);
                break;
            case R.id.iv_template_heart /* 2131492972 */:
                this.f7614a.f7594r = 1004;
                this.f7614a.m7347a(false);
                break;
        }
        this.f7614a.m7356c(this.f7614a.f7594r);
    }
}
