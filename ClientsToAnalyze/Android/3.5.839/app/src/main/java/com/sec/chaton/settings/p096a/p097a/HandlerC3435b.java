package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;

/* compiled from: AniconInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.b */
/* loaded from: classes.dex */
final class HandlerC3435b extends Handler {
    HandlerC3435b() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        super.handleMessage(message);
        if (message.what == 1) {
            C3436c c3436c = (C3436c) message.obj;
            if (c3436c.f12852a) {
                i = (int) (message.arg1 * 0.2d);
            } else {
                i = ((int) (message.arg1 * 0.8d)) + 20;
            }
            c3436c.f12853b.m19060e(Integer.valueOf(i));
        }
    }
}
