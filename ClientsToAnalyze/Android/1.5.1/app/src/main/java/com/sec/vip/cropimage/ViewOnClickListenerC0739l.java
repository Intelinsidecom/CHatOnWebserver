package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.cropimage.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC0739l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f4479a;

    ViewOnClickListenerC0739l(ImageModify imageModify) {
        this.f4479a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_ok /* 2131427351 */:
                this.f4479a.m4297e();
                this.f4479a.f4420v.dismiss();
                this.f4479a.f4420v = null;
                break;
            case C0062R.id.btn_cancel /* 2131427352 */:
                this.f4479a.f4420v.cancel();
                this.f4479a.f4420v.dismiss();
                this.f4479a.f4420v = null;
                break;
            case C0062R.id.iv_template_rect /* 2131427403 */:
                this.f4479a.f4415q = MsgResultCode.SUCCESS;
                break;
            case C0062R.id.iv_template_circle /* 2131427404 */:
                this.f4479a.f4415q = 1002;
                break;
            case C0062R.id.iv_template_roundrect /* 2131427405 */:
                this.f4479a.f4415q = 1001;
                break;
            case C0062R.id.iv_template_heart /* 2131427406 */:
                this.f4479a.f4415q = 1004;
                break;
            case C0062R.id.iv_template_star /* 2131427407 */:
                this.f4479a.f4415q = 1003;
                break;
        }
        this.f4479a.m4284a(this.f4479a.f4415q);
    }
}
