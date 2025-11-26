package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.ci */
/* loaded from: classes.dex */
class HandlerC2475ci extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2474ch f9335a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2475ci(C2474ch c2474ch, Looper looper) {
        super(looper);
        this.f9335a = c2474ch;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f9335a.f9334a.f9100i) {
            super.handleMessage(message);
            if (message.what == 1003) {
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                if (GlobalApplication.f5511a == null) {
                    zBooleanValue = false;
                }
                C2688ey.m9691a(CommonApplication.m11493l(), zBooleanValue);
                if (this.f9335a.f9334a.f9099h != null && this.f9335a.f9334a.f9099h.isShowing()) {
                    this.f9335a.f9334a.f9099h.dismiss();
                }
            }
        }
    }
}
