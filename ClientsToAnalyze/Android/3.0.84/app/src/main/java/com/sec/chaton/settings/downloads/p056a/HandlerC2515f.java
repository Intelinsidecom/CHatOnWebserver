package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: AniconInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.f */
/* loaded from: classes.dex */
final class HandlerC2515f extends Handler {
    HandlerC2515f() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        super.handleMessage(message);
        if (message.what == 1) {
            C2516g c2516g = (C2516g) message.obj;
            if (c2516g.f9627a) {
                i = (int) (message.arg1 * 0.2d);
            } else {
                i = ((int) (message.arg1 * 0.8d)) + 20;
            }
            c2516g.f9628b.m11746e(Integer.valueOf(i));
        }
    }
}
