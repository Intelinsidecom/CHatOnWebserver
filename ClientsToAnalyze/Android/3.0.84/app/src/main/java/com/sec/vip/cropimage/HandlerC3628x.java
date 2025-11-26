package com.sec.vip.cropimage;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.x */
/* loaded from: classes.dex */
class HandlerC3628x extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageModify f13338a;

    HandlerC3628x(ImageModify imageModify) {
        this.f13338a = imageModify;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 809:
                if (((C0274k) message.obj).f858a) {
                    this.f13338a.m12947i();
                    this.f13338a.setResult(-1, this.f13338a.f13199D);
                    this.f13338a.finish();
                    break;
                } else {
                    this.f13338a.m12947i();
                    AbstractC3271a.m11494a(this.f13338a.f13198C).mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3630z(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3629y(this)).mo11511b(true).mo11512b();
                    break;
                }
        }
    }
}
