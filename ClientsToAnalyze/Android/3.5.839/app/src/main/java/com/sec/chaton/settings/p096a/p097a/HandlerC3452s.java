package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;

/* compiled from: SoundInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.s */
/* loaded from: classes.dex */
final class HandlerC3452s extends Handler {
    HandlerC3452s() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            ((C3451r) message.obj).m19060e(Integer.valueOf(message.arg1));
        }
    }
}
