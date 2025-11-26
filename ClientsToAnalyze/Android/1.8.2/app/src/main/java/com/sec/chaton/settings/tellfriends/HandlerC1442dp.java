package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dp */
/* loaded from: classes.dex */
class HandlerC1442dp extends Handler {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5336a;

    HandlerC1442dp(WeiboSignIn weiboSignIn) {
        this.f5336a = weiboSignIn;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 9001:
                this.f5336a.m5044b();
                break;
        }
        super.handleMessage(message);
    }
}
