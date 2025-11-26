package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.j */
/* loaded from: classes.dex */
class HandlerC4545j extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveMainFragment f16405a;

    HandlerC4545j(ChatONLiveMainFragment chatONLiveMainFragment) {
        this.f16405a = chatONLiveMainFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f16405a.loadUrl((String) message.obj);
    }
}
