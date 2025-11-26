package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC2084h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f7573a;

    ViewOnClickListenerC2084h(ImageModify imageModify) {
        this.f7573a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131492890 */:
                this.f7573a.f7512x.cancel();
                this.f7573a.f7512x.dismiss();
                this.f7573a.f7512x = null;
                break;
            case R.id.btn_ok /* 2131492891 */:
                this.f7573a.m7291f();
                this.f7573a.f7512x.dismiss();
                this.f7573a.f7512x = null;
                break;
            case R.id.iv_template_rect /* 2131492968 */:
                this.f7573a.f7507s = 1000;
                break;
            case R.id.iv_template_roundrect /* 2131492969 */:
                this.f7573a.f7507s = 1001;
                break;
            case R.id.iv_template_circle /* 2131492970 */:
                this.f7573a.f7507s = 1002;
                break;
            case R.id.iv_template_star /* 2131492971 */:
                this.f7573a.f7507s = 1003;
                break;
            case R.id.iv_template_heart /* 2131492972 */:
                this.f7573a.f7507s = 1004;
                break;
        }
        this.f7573a.m7278a(this.f7573a.f7507s);
    }
}
