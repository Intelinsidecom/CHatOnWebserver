package com.sec.vip.amschaton.ics;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.as */
/* loaded from: classes.dex */
class HandlerC1488as extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5303a;

    HandlerC1488as(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5303a = aMSMyWorksActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (message.arg1 == 0) {
                    this.f5303a.m5448b(false);
                    break;
                } else if (message.arg1 == 1) {
                    this.f5303a.m5448b(true);
                    break;
                }
                break;
        }
    }
}
