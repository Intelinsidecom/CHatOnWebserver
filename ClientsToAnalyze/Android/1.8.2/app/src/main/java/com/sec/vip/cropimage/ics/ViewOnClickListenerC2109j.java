package com.sec.vip.cropimage.ics;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC2109j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7674a;

    ViewOnClickListenerC2109j(CropImage cropImage) {
        this.f7674a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_template_rect /* 2131492968 */:
                this.f7674a.f7650q = 1000;
                this.f7674a.m7396a(false);
                break;
            case R.id.iv_template_roundrect /* 2131492969 */:
                this.f7674a.f7650q = 1001;
                this.f7674a.m7396a(false);
                break;
            case R.id.iv_template_circle /* 2131492970 */:
                this.f7674a.f7650q = 1002;
                this.f7674a.m7396a(false);
                break;
            case R.id.iv_template_star /* 2131492971 */:
                this.f7674a.f7650q = 1003;
                this.f7674a.m7396a(false);
                break;
            case R.id.iv_template_heart /* 2131492972 */:
                this.f7674a.f7650q = 1004;
                this.f7674a.m7396a(false);
                break;
        }
        this.f7674a.m7403c(this.f7674a.f7650q);
    }
}
