package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: AmsItemInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.b */
/* loaded from: classes.dex */
final class HandlerC2511b extends Handler {
    HandlerC2511b() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            ((C2510a) message.obj).m11746e(Integer.valueOf(message.arg1));
        }
    }
}
