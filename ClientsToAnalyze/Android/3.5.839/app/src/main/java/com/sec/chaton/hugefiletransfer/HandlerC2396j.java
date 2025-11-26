package com.sec.chaton.hugefiletransfer;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: HugeFileUploadService.java */
/* renamed from: com.sec.chaton.hugefiletransfer.j */
/* loaded from: classes.dex */
class HandlerC2396j extends Handler {

    /* renamed from: a */
    final /* synthetic */ HugeFileUploadService f8507a;

    HandlerC2396j(HugeFileUploadService hugeFileUploadService) {
        this.f8507a = hugeFileUploadService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        int i = message.what;
        int i2 = message.arg1;
        C3890m.m14997c(HugeFileUploadService.f8481a, "mMmsHandler. token:" + i + " result:" + i2);
        switch (i2) {
            case 0:
                this.f8507a.m10380b(i);
                break;
        }
    }
}
