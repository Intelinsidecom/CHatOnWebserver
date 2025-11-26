package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.av */
/* loaded from: classes.dex */
class HandlerC0944av extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3890a;

    HandlerC0944av(ChatFragment chatFragment) {
        this.f3890a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                this.f3890a.f3514P.removeMessages(100);
                this.f3890a.m4784aD();
                break;
        }
    }
}
