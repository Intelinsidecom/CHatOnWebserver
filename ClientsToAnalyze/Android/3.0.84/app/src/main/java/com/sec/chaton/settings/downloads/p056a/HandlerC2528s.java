package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;

/* compiled from: SkinInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.s */
/* loaded from: classes.dex */
final class HandlerC2528s extends Handler {
    HandlerC2528s() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        super.handleMessage(message);
        if (message.what == 1) {
            C2529t c2529t = (C2529t) message.obj;
            if (c2529t.f9655a) {
                i = (int) (message.arg1 * 0.2d);
            } else {
                i = ((int) (message.arg1 * 0.8d)) + 20;
            }
            c2529t.f9656b.m11746e(Integer.valueOf(i));
        }
    }
}
