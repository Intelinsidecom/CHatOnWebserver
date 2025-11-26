package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatONLiveBuddyListFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.f */
/* loaded from: classes.dex */
class HandlerC2925f extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveBuddyListFragment f10455a;

    HandlerC2925f(ChatONLiveBuddyListFragment chatONLiveBuddyListFragment) {
        this.f10455a = chatONLiveBuddyListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f10455a.m6953a((String) message.obj);
    }
}
