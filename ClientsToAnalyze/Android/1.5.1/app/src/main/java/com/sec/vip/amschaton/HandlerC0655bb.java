package com.sec.vip.amschaton;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sec.vip.amschaton.bb */
/* loaded from: classes.dex */
class HandlerC0655bb extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4269a;

    HandlerC0655bb(AMSFileListActivity aMSFileListActivity) {
        this.f4269a = aMSFileListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f4269a.m3924j();
        this.f4269a.m3925k();
    }
}
