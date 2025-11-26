package android.support.v4.content;

import android.os.Handler;
import android.os.Message;

/* compiled from: ModernAsyncTask.java */
/* renamed from: android.support.v4.content.s */
/* loaded from: classes.dex */
class HandlerC0106s extends Handler {
    private HandlerC0106s() {
    }

    /* synthetic */ HandlerC0106s(ThreadFactoryC0101n threadFactoryC0101n) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0105r c0105r = (C0105r) message.obj;
        switch (message.what) {
            case 1:
                c0105r.f342a.m370e(c0105r.f343b[0]);
                break;
            case 2:
                c0105r.f342a.m375b((Object[]) c0105r.f343b);
                break;
        }
    }
}
