package com.sec.chaton.control;

import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.push.IPushClientService;

/* loaded from: classes.dex */
public class PushControl extends AbstractPushControl {
    public PushControl() {
        super("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.control.AbstractServiceWrapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo1985b(IBinder iBinder) {
        return IPushClientService.Stub.m2854a(iBinder);
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: a */
    public void mo1974a(Handler handler) {
        m1984a(new RunnableC0172aa(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: a */
    public void mo1975a(String str) {
        m1984a(new RunnableC0210y(this, str));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: b */
    public void mo1976b(Handler handler) {
        m1984a(new RunnableC0175d(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: c */
    public void mo1977c(Handler handler) {
        m1984a(new RunnableC0171a(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: d */
    public void mo1978d(Handler handler) {
        m1984a(new RunnableC0179h(this, handler));
    }
}
