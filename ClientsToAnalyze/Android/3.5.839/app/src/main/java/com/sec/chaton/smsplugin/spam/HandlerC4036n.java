package com.sec.chaton.smsplugin.spam;

import android.os.Handler;
import android.os.Message;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.n */
/* loaded from: classes.dex */
class HandlerC4036n extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14550a;

    HandlerC4036n(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14550a = setupSpamKeywordList;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 100) {
            this.f14550a.f14302c.notifyDataSetChanged();
        }
    }
}
