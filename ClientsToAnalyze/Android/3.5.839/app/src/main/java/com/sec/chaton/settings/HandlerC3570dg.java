package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.dg */
/* loaded from: classes.dex */
class HandlerC3570dg extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3569df f13059a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3570dg(C3569df c3569df, Looper looper) {
        super(looper);
        this.f13059a = c3569df;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f13059a.f13058a.f12660i) {
            super.handleMessage(message);
            if (message.what == 1003) {
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                if (GlobalApplication.f8355a == null) {
                    zBooleanValue = false;
                }
                C3640fw.m13919a(CommonApplication.m18732r(), zBooleanValue);
                if (this.f13059a.f13058a.f12659h != null && this.f13059a.f13058a.f12659h.isShowing()) {
                    this.f13059a.f13058a.f12659h.dismiss();
                }
            }
        }
    }
}
