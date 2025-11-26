package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.network.connection.AbstractConnectionManager;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.c */
/* loaded from: classes.dex */
class C0368c implements AbstractConnectionManager.OnConnectionChangedListener {

    /* renamed from: a */
    final /* synthetic */ InitMessageProcesser f2681a;

    C0368c(InitMessageProcesser initMessageProcesser) {
        this.f2681a = initMessageProcesser;
    }

    @Override // com.sec.chaton.push.network.connection.AbstractConnectionManager.OnConnectionChangedListener
    /* renamed from: a */
    public void mo2961a() {
        PushLog.m3031d(InitMessageProcesser.f2628d, "Error handling case of disconnect");
        this.f2681a.f2623b.m2921a(false);
    }

    @Override // com.sec.chaton.push.network.connection.AbstractConnectionManager.OnConnectionChangedListener
    /* renamed from: b */
    public void mo2962b() {
    }
}
