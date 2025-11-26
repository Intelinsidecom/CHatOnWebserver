package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: InstallAsyncWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.o */
/* loaded from: classes.dex */
class HandlerC2524o extends Handler {
    private HandlerC2524o() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2521l c2521l = (C2521l) message.obj;
        switch (message.what) {
            case 1:
                c2521l.m9443a(1);
                break;
            case 2:
                c2521l.m9443a(2);
                break;
        }
    }
}
