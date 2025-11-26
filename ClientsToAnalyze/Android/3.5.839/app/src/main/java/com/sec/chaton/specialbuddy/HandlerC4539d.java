package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import android.webkit.ValueCallback;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.d */
/* loaded from: classes.dex */
class HandlerC4539d extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16399a;

    HandlerC4539d(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16399a = abstractChatONLiveFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f16399a.isValidActivity()) {
            switch (message.what) {
                case 0:
                    if (message.obj instanceof ValueCallback) {
                        this.f16399a.f16287g = (ValueCallback) message.obj;
                        this.f16399a.m17126d();
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }
}
