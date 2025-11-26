package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC3612h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f13284a;

    ViewOnClickListenerC3612h(CropImage cropImage) {
        this.f13284a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_template_rect /* 2131165768 */:
                this.f13284a.f13182u = 1000;
                this.f13284a.m12884b(false);
                break;
            case R.id.iv_template_roundrect /* 2131165769 */:
                this.f13284a.f13182u = 1001;
                this.f13284a.m12884b(false);
                break;
            case R.id.iv_template_circle /* 2131165770 */:
                this.f13284a.f13182u = 1002;
                this.f13284a.m12884b(false);
                break;
            case R.id.iv_template_star /* 2131165771 */:
                this.f13284a.f13182u = 1003;
                this.f13284a.m12884b(false);
                break;
            case R.id.iv_template_heart /* 2131165772 */:
                this.f13284a.f13182u = 1004;
                this.f13284a.m12884b(false);
                break;
        }
        this.f13284a.m12887c(this.f13284a.f13182u);
    }
}
