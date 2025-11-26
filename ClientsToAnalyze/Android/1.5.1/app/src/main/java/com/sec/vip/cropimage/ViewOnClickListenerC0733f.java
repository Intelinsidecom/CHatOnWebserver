package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.cropimage.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0733f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f4472a;

    ViewOnClickListenerC0733f(CropImage cropImage) {
        this.f4472a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_cancel /* 2131427352 */:
                this.f4472a.f4383v.cancel();
                break;
            case C0062R.id.iv_template_rect /* 2131427403 */:
                this.f4472a.f4378q = MsgResultCode.SUCCESS;
                this.f4472a.m4254e();
                break;
            case C0062R.id.iv_template_circle /* 2131427404 */:
                this.f4472a.f4378q = 1002;
                this.f4472a.m4254e();
                break;
            case C0062R.id.iv_template_roundrect /* 2131427405 */:
                this.f4472a.f4378q = 1001;
                this.f4472a.m4254e();
                break;
            case C0062R.id.iv_template_heart /* 2131427406 */:
                this.f4472a.f4378q = 1004;
                this.f4472a.m4254e();
                break;
            case C0062R.id.iv_template_star /* 2131427407 */:
                this.f4472a.f4378q = 1003;
                this.f4472a.m4254e();
                break;
        }
        this.f4472a.f4383v.dismiss();
        this.f4472a.f4383v = null;
        this.f4472a.m4239a(this.f4472a.f4378q);
    }
}
