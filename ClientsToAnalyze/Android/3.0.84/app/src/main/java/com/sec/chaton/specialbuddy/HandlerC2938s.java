package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.s */
/* loaded from: classes.dex */
class HandlerC2938s extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10474a;

    HandlerC2938s(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10474a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f10474a.m6953a((String) message.obj);
    }
}
