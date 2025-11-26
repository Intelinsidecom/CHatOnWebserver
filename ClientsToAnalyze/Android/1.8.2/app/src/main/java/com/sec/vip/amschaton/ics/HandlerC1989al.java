package com.sec.vip.amschaton.ics;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.al */
/* loaded from: classes.dex */
class HandlerC1989al extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7263a;

    HandlerC1989al(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7263a = aMSMyWorksActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (message.arg1 == 0) {
                    this.f7263a.m7012c(false);
                    break;
                } else if (message.arg1 == 1) {
                    this.f7263a.m7012c(true);
                    break;
                }
                break;
        }
    }
}
