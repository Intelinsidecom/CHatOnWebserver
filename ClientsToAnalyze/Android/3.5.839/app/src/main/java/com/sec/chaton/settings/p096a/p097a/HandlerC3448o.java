package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;

/* compiled from: SkinInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.o */
/* loaded from: classes.dex */
final class HandlerC3448o extends Handler {
    HandlerC3448o() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        super.handleMessage(message);
        if (message.what == 1) {
            C3449p c3449p = (C3449p) message.obj;
            if (c3449p.f12888a) {
                i = (int) (message.arg1 * 0.2d);
            } else {
                i = ((int) (message.arg1 * 0.8d)) + 20;
            }
            c3449p.f12889b.m19060e(Integer.valueOf(i));
        }
    }
}
