package com.sec.common.util;

import android.os.Handler;
import android.os.Message;

/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.f */
/* loaded from: classes.dex */
class HandlerC3344f extends Handler {
    private HandlerC3344f() {
    }

    /* synthetic */ HandlerC3344f(C3340b c3340b) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C3343e c3343e = (C3343e) message.obj;
        switch (message.what) {
            case 1:
                c3343e.f12073a.m11741c((AbstractC3331a) c3343e.f12074b[0]);
                break;
            case 2:
                c3343e.f12073a.mo9448a((AbstractC3331a) c3343e.f12074b[0]);
                break;
            case 3:
                c3343e.f12073a.mo9457f();
                break;
        }
    }
}
