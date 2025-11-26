package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC0908j;
import com.sec.chaton.push.InterfaceC0903g;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.r */
/* loaded from: classes.dex */
public class C0219r extends AbstractC0196ai {

    /* renamed from: c */
    private static final String f530c = C0219r.class.getSimpleName();

    public C0219r() {
        super("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION");
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: a */
    public void mo741a(Handler handler) {
        m734a(new RunnableC0201an(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: b */
    public void mo743b(Handler handler) {
        m734a(new RunnableC0207f(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: c */
    public void mo744c(Handler handler) {
        m734a(new RunnableC0123a(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: d */
    public void mo745d(Handler handler) {
        m734a(new RunnableC0221t(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: a */
    public void mo742a(String str) {
        m734a(new RunnableC0198ak(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p013a.AbstractC0191ad
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC0903g mo735b(IBinder iBinder) {
        return AbstractBinderC0908j.m3596a(iBinder);
    }
}
