package com.sec.chaton.calllog.common.view.swipe;

import android.os.Handler;
import android.os.Message;

/* compiled from: SwipeLayout.java */
/* renamed from: com.sec.chaton.calllog.common.view.swipe.d */
/* loaded from: classes.dex */
class HandlerC1446d extends Handler {

    /* renamed from: a */
    final /* synthetic */ SwipeLayout f5169a;

    /* renamed from: b */
    private boolean f5170b;

    private HandlerC1446d(SwipeLayout swipeLayout) {
        this.f5169a = swipeLayout;
        this.f5170b = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f5170b) {
            if (message.what == 1) {
                this.f5169a.setPressed(true);
            } else if (message.what == 2) {
                this.f5169a.setPressed(false);
                this.f5169a.setBackgroundColor(0);
            } else if (message.what == 3 && this.f5169a.f5151e == 1) {
                this.f5169a.m7546a();
            }
            super.handleMessage(message);
        }
    }
}
