package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: SoundInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.w */
/* loaded from: classes.dex */
final class HandlerC2532w extends Handler {
    HandlerC2532w() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            ((C2531v) message.obj).m11746e(Integer.valueOf(message.arg1));
        }
    }
}
