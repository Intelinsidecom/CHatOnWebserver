package com.sec.vip.amschaton.honeycomb;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.o */
/* loaded from: classes.dex */
class HandlerC1456o extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5102a;

    HandlerC1456o(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5102a = aMSMyWorksActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (message.arg1 == 0) {
                    this.f5102a.m5133b(false);
                    break;
                } else if (message.arg1 == 1) {
                    this.f5102a.m5133b(true);
                    break;
                }
                break;
        }
    }
}
