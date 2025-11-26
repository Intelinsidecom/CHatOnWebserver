package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC3093f;
import com.sec.chaton.push.InterfaceC3092e;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ar */
/* loaded from: classes.dex */
public class C2085ar extends AbstractC1899a<InterfaceC3092e> {

    /* renamed from: c */
    private static final String f7591c = C2085ar.class.getSimpleName();

    public C2085ar() {
        super("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION");
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: a */
    public void mo9077a(Handler handler) {
        m9345a(new RunnableC2091ax(this, handler));
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: b */
    public void mo9079b(Handler handler) {
        m9345a(new RunnableC2086as(this, handler));
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: c */
    public void mo9080c(Handler handler) {
        m9345a(new RunnableC2089av(this, handler));
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: d */
    public void mo9081d(Handler handler) {
        m9345a(new RunnableC2088au(this, handler));
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: a */
    public void mo9078a(String str) {
        m9345a(new RunnableC2090aw(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p055d.AbstractC2094b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC3092e mo9327a(IBinder iBinder) {
        return AbstractBinderC3093f.m12601a(iBinder);
    }
}
