package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.call.model.I */
/* loaded from: classes.dex */
class HandlerC1194I extends Handler implements DisposeInterface {

    /* renamed from: a */
    final /* synthetic */ C1193H f2632a;

    /* renamed from: b */
    private boolean f2633b = false;

    HandlerC1194I(C1193H c1193h) {
        this.f2632a = c1193h;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.f2633b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2633b) {
            return;
        }
        this.f2632a.f2630M++;
        if (!this.f2632a.m2406Q() && this.f2632a.f2630M != 10) {
            this.f2632a.f2631N.removeMessages(0);
            this.f2632a.f2631N.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        this.f2632a.m2424h("haeri=top activity true");
        if (this.f2632a.f2549r != null) {
            this.f2632a.f2549r.onCallHoldState(false);
        }
        this.f2632a.f2630M = 0;
        this.f2632a.f2631N.removeMessages(0);
        this.f2632a.f2631N = null;
    }
}
