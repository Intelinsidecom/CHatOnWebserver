package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.v */
/* loaded from: classes.dex */
class HandlerC1473v extends Handler {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5393a;

    HandlerC1473v(OauthSignin oauthSignin) {
        this.f5393a = oauthSignin;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 9001:
                this.f5393a.m4821b();
                break;
        }
        super.handleMessage(message);
    }
}
