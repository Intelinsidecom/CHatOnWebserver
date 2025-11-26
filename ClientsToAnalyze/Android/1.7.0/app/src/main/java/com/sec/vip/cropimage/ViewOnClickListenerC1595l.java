package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC1595l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f5615a;

    ViewOnClickListenerC1595l(ImageModify imageModify) {
        this.f5615a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131427356 */:
                this.f5615a.f5474y.cancel();
                this.f5615a.f5474y.dismiss();
                this.f5615a.f5474y = null;
                break;
            case R.id.btn_ok /* 2131427357 */:
                this.f5615a.m5699f();
                this.f5615a.f5474y.dismiss();
                this.f5615a.f5474y = null;
                break;
            case R.id.iv_template_rect /* 2131427418 */:
                this.f5615a.f5469t = 1000;
                break;
            case R.id.iv_template_roundrect /* 2131427419 */:
                this.f5615a.f5469t = 1001;
                break;
            case R.id.iv_template_circle /* 2131427420 */:
                this.f5615a.f5469t = 1002;
                break;
            case R.id.iv_template_star /* 2131427421 */:
                this.f5615a.f5469t = 1003;
                break;
            case R.id.iv_template_heart /* 2131427422 */:
                this.f5615a.f5469t = 1004;
                break;
        }
        this.f5615a.m5685a(this.f5615a.f5469t);
    }
}
