package com.sec.chaton.p013a;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.spp.push.Config;
import com.sec.spp.push.IPushClientService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.k */
/* loaded from: classes.dex */
public class C0212k extends AbstractC0196ai {

    /* renamed from: c */
    private static final String f514c = C0212k.class.getSimpleName();

    /* renamed from: d */
    private static C0212k f515d;

    /* renamed from: e */
    private Map f516e;

    /* renamed from: f */
    private C0194ag f517f;

    private C0212k() {
        super("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");
        this.f516e = new HashMap();
        this.f517f = new C0194ag(this);
        GlobalApplication.m3100a().registerReceiver(this.f517f, new IntentFilter(Config.PUSH_REGISTRATION_CHANGED_ACTION));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        GlobalApplication.m3100a().unregisterReceiver(this.f517f);
    }

    /* renamed from: a_ */
    public static C0212k m778a_() {
        if (f515d == null) {
            f515d = new C0212k();
        }
        return f515d;
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: a */
    public void mo741a(Handler handler) {
        m734a(new RunnableC0213l(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: b */
    public void mo743b(Handler handler) {
        m734a(new RunnableC0204c(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: c */
    public void mo744c(Handler handler) {
        m734a(new RunnableC0188aa(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: d */
    public void mo745d(Handler handler) {
        m734a(new RunnableC0193af(this, handler));
    }

    @Override // com.sec.chaton.p013a.AbstractC0196ai
    /* renamed from: a */
    public void mo742a(String str) {
        m734a(new RunnableC0222u(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p013a.AbstractC0191ad
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo735b(IBinder iBinder) {
        return IPushClientService.Stub.asInterface(iBinder);
    }
}
