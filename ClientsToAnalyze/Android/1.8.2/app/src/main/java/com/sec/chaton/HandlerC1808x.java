package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.x */
/* loaded from: classes.dex */
class HandlerC1808x extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f6500a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1808x(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f6500a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
            GlobalApplication.f2775a = null;
        }
    }
}
