package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.specialbuddy.p117a.AsyncTaskC4528d;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ef */
/* loaded from: classes.dex */
class HandlerC2312ef extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8235a;

    HandlerC2312ef(TabActivity tabActivity) {
        this.f8235a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C4904y.f17872b) {
            C4904y.m18639b("livechat, feedback, timer end. request Feedback", TabActivity.f2029t);
        }
        new AsyncTaskC4528d().execute(new Void[0]);
        super.handleMessage(message);
    }
}
