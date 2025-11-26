package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bj */
/* loaded from: classes.dex */
class HandlerC1602bj extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6117a;

    HandlerC1602bj(ChatFragment chatFragment) {
        this.f6117a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f6117a.m8119c(message.arg1);
    }
}
