package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC1119e;
import com.sec.chaton.push.InterfaceC1118d;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ab */
/* loaded from: classes.dex */
public class C0612ab extends AbstractC0531a {

    /* renamed from: c */
    private static final String f2425c = C0612ab.class.getSimpleName();

    public C0612ab() {
        super("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION");
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: a */
    public void mo2702a(Handler handler) {
        m2841a(new RunnableC0618ah(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: b */
    public void mo2704b(Handler handler) {
        m2841a(new RunnableC0613ac(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: c */
    public void mo2705c(Handler handler) {
        m2841a(new RunnableC0616af(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: d */
    public void mo2706d(Handler handler) {
        m2841a(new RunnableC0615ae(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: a */
    public void mo2703a(String str) {
        m2841a(new RunnableC0617ag(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p015d.AbstractC0630b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC1118d mo2796a(IBinder iBinder) {
        return AbstractBinderC1119e.m4212a(iBinder);
    }
}
