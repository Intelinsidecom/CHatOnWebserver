package com.sec.vip.cropimage;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0790n;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.j */
/* loaded from: classes.dex */
class HandlerC5123j extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageModify f18696a;

    HandlerC5123j(ImageModify imageModify) {
        this.f18696a = imageModify;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 809:
                if (((C0790n) message.obj).f2172a) {
                    this.f18696a.m19534n();
                    this.f18696a.setResult(-1, this.f18696a.f18623P);
                    this.f18696a.finish();
                    break;
                } else {
                    this.f18696a.m19534n();
                    AbstractC4932a.m18733a(this.f18696a.f18622O).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC5125l(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC5124k(this)).mo18751b(true).mo18752b();
                    break;
                }
        }
    }
}
