package com.sds.coolots.call;

import android.os.SystemClock;

/* renamed from: com.sds.coolots.call.u */
/* loaded from: classes.dex */
class C1233u extends Thread {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2869a;

    private C1233u(HandlerC1227o handlerC1227o) {
        this.f2869a = handlerC1227o;
    }

    /* synthetic */ C1233u(HandlerC1227o handlerC1227o, C1233u c1233u) {
        this(handlerC1227o);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.f2869a.f2856O) {
            this.f2869a.f2846C.vibrate(1500L);
            SystemClock.sleep(3500L);
        }
    }
}
