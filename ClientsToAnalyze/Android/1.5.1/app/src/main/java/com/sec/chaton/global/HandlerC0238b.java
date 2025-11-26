package com.sec.chaton.global;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.global.b */
/* loaded from: classes.dex */
class HandlerC0238b extends Handler {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f1906a;

    HandlerC0238b(GlobalApplication globalApplication) {
        this.f1906a = globalApplication;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        String str = (String) message.obj;
        ChatONLogWriter.m3508c("Push registration id: " + str, GlobalApplication.class.getSimpleName());
        GlobalApplication.f1895b = str;
    }
}
