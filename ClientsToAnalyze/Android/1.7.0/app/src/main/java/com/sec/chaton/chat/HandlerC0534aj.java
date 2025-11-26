package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.aj */
/* loaded from: classes.dex */
class HandlerC0534aj extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProgressBar f1882a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0603t f1883b;

    HandlerC0534aj(ViewOnClickListenerC0603t viewOnClickListenerC0603t, ProgressBar progressBar) {
        this.f1883b = viewOnClickListenerC0603t;
        this.f1882a = progressBar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            this.f1882a.setProgress(message.arg1);
        }
    }
}
