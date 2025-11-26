package com.sec.chaton.settings.moreapps;

import android.os.Handler;
import android.os.Message;

/* compiled from: EventFragment.java */
/* renamed from: com.sec.chaton.settings.moreapps.b */
/* loaded from: classes.dex */
class HandlerC3670b extends Handler {

    /* renamed from: a */
    final /* synthetic */ EventFragment f13253a;

    HandlerC3670b(EventFragment eventFragment) {
        this.f13253a = eventFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        this.f13253a.loadUrl((String) message.obj);
    }
}
