package com.sec.chaton.calllog.common.view.swipe;

import android.os.Handler;
import android.os.Message;

/* compiled from: SwipeLayout.java */
/* renamed from: com.sec.chaton.calllog.common.view.swipe.d */
/* loaded from: classes.dex */
class HandlerC0835d extends Handler {

    /* renamed from: a */
    final /* synthetic */ SwipeLayout f3199a;

    /* renamed from: b */
    private boolean f3200b;

    private HandlerC0835d(SwipeLayout swipeLayout) {
        this.f3199a = swipeLayout;
        this.f3200b = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3200b) {
            if (message.what == 1) {
                this.f3199a.setPressed(true);
            } else if (message.what == 2) {
                this.f3199a.setPressed(false);
                this.f3199a.setBackgroundColor(0);
            } else if (message.what == 3 && this.f3199a.f3181e == 1) {
                this.f3199a.m4392a();
            }
            super.handleMessage(message);
        }
    }
}
