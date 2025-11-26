package com.sec.vip.amschaton.honeycomb;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.s */
/* loaded from: classes.dex */
class HandlerC1968s extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7115a;

    HandlerC1968s(AMSComposerActivity aMSComposerActivity) {
        this.f7115a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f7115a.f6914C != null) {
            if (message.what == 1) {
                this.f7115a.f6914C.m6318k();
            } else {
                this.f7115a.f6914C.m6319l();
            }
        }
    }
}
