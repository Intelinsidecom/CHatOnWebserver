package com.sec.chaton.hugefiletransfer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C4904y;

/* compiled from: HugeFileUploadTask.java */
/* renamed from: com.sec.chaton.hugefiletransfer.l */
/* loaded from: classes.dex */
class HandlerC2398l extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2397k f8533a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2398l(C2397k c2397k, Looper looper) {
        super(looper);
        this.f8533a = c2397k;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 4:
                C2394h c2394h = (C2394h) message.obj;
                if (c2394h.m18953m() == 200) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("HTTP_MC_UPLOAD_CHUNK : " + c2394h.m10392a(), C2397k.f8508a);
                    }
                    this.f8533a.f8520m.sendMessage(Message.obtain(this.f8533a.f8520m, 2, new C2402p(this.f8533a.f8524q, this.f8533a.f8522o.getName(), this.f8533a.f8523p, this.f8533a.f8527t + C2397k.m10409e(this.f8533a), this.f8533a.f8529v)));
                    break;
                }
                break;
        }
    }
}
