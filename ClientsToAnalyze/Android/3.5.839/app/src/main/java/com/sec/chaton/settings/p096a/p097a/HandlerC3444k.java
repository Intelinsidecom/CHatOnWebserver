package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;

/* compiled from: InstallAsyncWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.k */
/* loaded from: classes.dex */
class HandlerC3444k extends Handler {
    private HandlerC3444k() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C3441h c3441h = (C3441h) message.obj;
        switch (message.what) {
            case 1:
                c3441h.m13714a(1);
                break;
            case 2:
                c3441h.m13714a(2);
                break;
        }
    }
}
