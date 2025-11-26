package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC2093f;
import com.sec.chaton.push.InterfaceC2092e;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ag */
/* loaded from: classes.dex */
public class C1294ag extends AbstractC1144a<InterfaceC2092e> {

    /* renamed from: c */
    private static final String f4918c = C1294ag.class.getSimpleName();

    public C1294ag() {
        super("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION");
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: a */
    public void mo5479a(Handler handler) {
        m5667a(new RunnableC1300am(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: b */
    public void mo5481b(Handler handler) {
        m5667a(new RunnableC1295ah(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: c */
    public void mo5482c(Handler handler) {
        m5667a(new RunnableC1298ak(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: d */
    public void mo5483d(Handler handler) {
        m5667a(new RunnableC1297aj(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: a */
    public void mo5480a(String str) {
        m5667a(new RunnableC1299al(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p025d.AbstractC1314b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC2092e mo5586a(IBinder iBinder) {
        return AbstractBinderC2093f.m8258a(iBinder);
    }
}
