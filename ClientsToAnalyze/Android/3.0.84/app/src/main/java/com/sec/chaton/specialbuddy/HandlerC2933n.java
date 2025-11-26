package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.n */
/* loaded from: classes.dex */
class HandlerC2933n extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveMainFragment f10464a;

    HandlerC2933n(ChatONLiveMainFragment chatONLiveMainFragment) {
        this.f10464a = chatONLiveMainFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f10464a.m6953a((String) message.obj);
    }
}
