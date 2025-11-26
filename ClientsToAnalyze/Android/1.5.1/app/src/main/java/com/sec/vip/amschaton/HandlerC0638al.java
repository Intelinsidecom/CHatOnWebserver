package com.sec.vip.amschaton;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sec.vip.amschaton.al */
/* loaded from: classes.dex */
class HandlerC0638al extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4249a;

    HandlerC0638al(AMSPlayerActivity aMSPlayerActivity) {
        this.f4249a = aMSPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f4249a.f4038y.setProgress(message.what);
    }
}
