package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatONLiveEventFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.i */
/* loaded from: classes.dex */
class HandlerC2928i extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveEventFragment f10459a;

    HandlerC2928i(ChatONLiveEventFragment chatONLiveEventFragment) {
        this.f10459a = chatONLiveEventFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f10459a.m6953a((String) message.obj);
    }
}
