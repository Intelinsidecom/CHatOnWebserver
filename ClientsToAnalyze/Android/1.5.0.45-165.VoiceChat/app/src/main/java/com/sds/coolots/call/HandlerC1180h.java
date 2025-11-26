package com.sds.coolots.call;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sds.coolots.call.h */
/* loaded from: classes.dex */
class HandlerC1180h extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1179g f2439a;

    HandlerC1180h(C1179g c1179g) {
        this.f2439a = c1179g;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 100) {
            this.f2439a.releaseLockForEnd();
        } else if (message.what == 101) {
            this.f2439a.f2433c.remove(message.obj);
        }
        super.handleMessage(message);
    }
}
