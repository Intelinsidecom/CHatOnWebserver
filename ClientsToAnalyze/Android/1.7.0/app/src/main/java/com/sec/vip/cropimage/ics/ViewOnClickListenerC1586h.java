package com.sec.vip.cropimage.ics;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC1586h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f5603a;

    ViewOnClickListenerC1586h(CropImage cropImage) {
        this.f5603a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_template_rect /* 2131427418 */:
                this.f5603a.f5579q = 1000;
                this.f5603a.m5783a(false);
                break;
            case R.id.iv_template_roundrect /* 2131427419 */:
                this.f5603a.f5579q = 1001;
                this.f5603a.m5783a(false);
                break;
            case R.id.iv_template_circle /* 2131427420 */:
                this.f5603a.f5579q = 1002;
                this.f5603a.m5783a(false);
                break;
            case R.id.iv_template_star /* 2131427421 */:
                this.f5603a.f5579q = 1003;
                this.f5603a.m5783a(false);
                break;
            case R.id.iv_template_heart /* 2131427422 */:
                this.f5603a.f5579q = 1004;
                this.f5603a.m5783a(false);
                break;
        }
        this.f5603a.m5790c(this.f5603a.f5579q);
    }
}
