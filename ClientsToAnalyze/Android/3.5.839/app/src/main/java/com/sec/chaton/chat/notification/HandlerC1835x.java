package com.sec.chaton.chat.notification;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.x */
/* loaded from: classes.dex */
class HandlerC1835x extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6957a;

    HandlerC1835x(ScreenNotification2 screenNotification2) {
        this.f6957a = screenNotification2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        switch (message.what) {
            case 200:
                this.f6957a.m8846e(message.arg1);
                break;
            case 201:
                this.f6957a.m8842d(message.arg1);
                break;
            case 202:
                this.f6957a.m8871v();
                break;
        }
    }
}
