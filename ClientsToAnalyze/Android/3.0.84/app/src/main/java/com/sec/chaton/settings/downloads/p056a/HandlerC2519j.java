package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: FontInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.j */
/* loaded from: classes.dex */
final class HandlerC2519j extends Handler {
    HandlerC2519j() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            ((C2518i) message.obj).m11746e(Integer.valueOf(message.arg1));
        }
    }
}
