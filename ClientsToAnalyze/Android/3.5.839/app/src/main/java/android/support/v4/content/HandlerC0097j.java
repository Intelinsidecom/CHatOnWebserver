package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LocalBroadcastManager.java */
/* renamed from: android.support.v4.content.j */
/* loaded from: classes.dex */
class HandlerC0097j extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0096i f323a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0097j(C0096i c0096i, Looper looper) {
        super(looper);
        this.f323a = c0096i;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f323a.m359a();
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }
}
