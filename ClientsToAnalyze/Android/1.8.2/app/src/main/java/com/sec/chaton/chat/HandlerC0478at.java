package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.at */
/* loaded from: classes.dex */
class HandlerC0478at extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProgressBar f2006a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0477as f2007b;

    HandlerC0478at(ViewOnClickListenerC0477as viewOnClickListenerC0477as, ProgressBar progressBar) {
        this.f2007b = viewOnClickListenerC0477as;
        this.f2006a = progressBar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            this.f2006a.setProgress(message.arg1);
        }
    }
}
