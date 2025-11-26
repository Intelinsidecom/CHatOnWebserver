package com.sec.chaton.smsplugin.spam;

import android.os.Handler;
import android.os.Message;

/* compiled from: SetupSpamNumberWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bo */
/* loaded from: classes.dex */
class HandlerC4011bo extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberWriteForm f14464a;

    HandlerC4011bo(SetupSpamNumberWriteForm setupSpamNumberWriteForm) {
        this.f14464a = setupSpamNumberWriteForm;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                System.out.println("DONE");
                break;
        }
    }
}
