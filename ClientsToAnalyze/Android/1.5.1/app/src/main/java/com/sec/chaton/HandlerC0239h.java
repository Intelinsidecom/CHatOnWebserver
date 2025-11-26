package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.h */
/* loaded from: classes.dex */
class HandlerC0239h extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f1907a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0239h(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f1907a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            GlobalApplication.f1895b = null;
        }
    }
}
