package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0254b;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.widget.C1619g;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ac */
/* loaded from: classes.dex */
class HandlerC1206ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4283a;

    HandlerC1206ac(UserProfileDetail userProfileDetail) {
        this.f4283a = userProfileDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f4283a.isFinishing()) {
            if (!this.f4283a.isFinishing() && this.f4283a.f4253v != null && this.f4283a.f4253v.isShowing()) {
                this.f4283a.f4253v.dismiss();
                this.f4283a.f4225G.setButtonEnabled(false);
            }
            switch (message.what) {
                case 401:
                    C0259g c0259g = (C0259g) message.obj;
                    if (!c0259g.m927a() || !c0259g.m927a()) {
                        this.f4283a.f4225G.setButtonEnabled(true);
                        C1619g.m5888a(this.f4283a.f4223E, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                    break;
                case 402:
                    if (((C0254b) message.obj).f604a) {
                        this.f4283a.m4388f();
                        break;
                    } else {
                        C1619g.m5888a(this.f4283a.f4223E, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                case 403:
                    C0259g c0259g2 = (C0259g) message.obj;
                    if (!c0259g2.m927a() || !c0259g2.m927a()) {
                        C1619g.m5888a(this.f4283a.f4223E, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    } else {
                        this.f4283a.m4391h();
                        break;
                    }
                    break;
            }
        }
    }
}
