package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;

/* compiled from: FontInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.f */
/* loaded from: classes.dex */
final class HandlerC3439f extends Handler {
    HandlerC3439f() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            ((C3438e) message.obj).m19060e(Integer.valueOf(message.arg1));
        }
    }
}
