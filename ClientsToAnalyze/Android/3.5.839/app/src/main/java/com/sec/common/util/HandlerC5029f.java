package com.sec.common.util;

import android.os.Handler;
import android.os.Message;

/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.f */
/* loaded from: classes.dex */
class HandlerC5029f extends Handler {
    private HandlerC5029f() {
    }

    /* synthetic */ HandlerC5029f(C5025b c5025b) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C5028e c5028e = (C5028e) message.obj;
        switch (message.what) {
            case 1:
                c5028e.f18338a.m19055c(c5028e.f18339b[0]);
                break;
            case 2:
                c5028e.f18338a.mo7398b(c5028e.f18339b[0]);
                break;
            case 3:
                c5028e.f18338a.mo6109b();
                break;
        }
    }
}
