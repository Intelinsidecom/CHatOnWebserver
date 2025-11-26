package com.sec.chaton.hugefiletransfer;

import android.os.Handler;
import android.os.Message;
import com.sec.widget.C5179v;

/* compiled from: HugeFileSendingMessageService.java */
/* renamed from: com.sec.chaton.hugefiletransfer.f */
/* loaded from: classes.dex */
class HandlerC2392f extends Handler {

    /* renamed from: a */
    final /* synthetic */ HugeFileSendingMessageService f8503a;

    HandlerC2392f(HugeFileSendingMessageService hugeFileSendingMessageService) {
        this.f8503a = hugeFileSendingMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (message.obj != null) {
                    C5179v.m19811a(this.f8503a.getApplicationContext(), message.obj.toString(), 0).show();
                    break;
                }
                break;
        }
    }
}
