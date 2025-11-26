package com.sec.chaton.mobileweb;

import android.os.Handler;
import android.os.Message;

/* compiled from: PageProgressView.java */
/* renamed from: com.sec.chaton.mobileweb.t */
/* loaded from: classes.dex */
class HandlerC2606t extends Handler {

    /* renamed from: a */
    final /* synthetic */ PageProgressView f9308a;

    HandlerC2606t(PageProgressView pageProgressView) {
        this.f9308a = pageProgressView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 42) {
            this.f9308a.f9223a = Math.min(this.f9308a.f9224b, this.f9308a.f9223a + this.f9308a.f9225c);
            this.f9308a.f9226d.right = (this.f9308a.getWidth() * this.f9308a.f9223a) / 10000;
            this.f9308a.invalidate();
            if (this.f9308a.f9223a < this.f9308a.f9224b) {
                sendMessageDelayed(this.f9308a.f9227e.obtainMessage(42), 40L);
            }
        }
    }
}
