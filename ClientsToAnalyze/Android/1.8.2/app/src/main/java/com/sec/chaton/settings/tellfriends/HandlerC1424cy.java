package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cy */
/* loaded from: classes.dex */
class HandlerC1424cy extends Handler {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5307a;

    HandlerC1424cy(TwitterSignIn twitterSignIn) {
        this.f5307a = twitterSignIn;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 9001:
                this.f5307a.m5008b();
                break;
        }
        super.handleMessage(message);
    }
}
