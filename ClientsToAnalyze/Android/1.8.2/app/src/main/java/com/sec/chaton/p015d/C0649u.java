package com.sec.chaton.p015d;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.spp.push.Config;
import com.sec.spp.push.IPushClientService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.u */
/* loaded from: classes.dex */
public class C0649u extends AbstractC0531a {

    /* renamed from: c */
    private static final String f2516c = C0649u.class.getSimpleName();

    /* renamed from: d */
    private static C0649u f2517d;

    /* renamed from: e */
    private Map f2518e;

    /* renamed from: f */
    private C0654z f2519f;

    private C0649u() {
        super("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");
        this.f2518e = new HashMap();
        this.f2519f = new C0654z(this);
        GlobalApplication.m3260b().registerReceiver(this.f2519f, new IntentFilter(Config.PUSH_REGISTRATION_CHANGED_ACTION));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        GlobalApplication.m3260b().unregisterReceiver(this.f2519f);
    }

    /* renamed from: e */
    public static C0649u m2967e() {
        if (f2517d == null) {
            f2517d = new C0649u();
        }
        return f2517d;
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: a */
    public void mo2702a(Handler handler) {
        m2841a(new RunnableC0611aa(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: b */
    public void mo2704b(Handler handler) {
        m2841a(new RunnableC0650v(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: c */
    public void mo2705c(Handler handler) {
        m2841a(new RunnableC0652x(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: d */
    public void mo2706d(Handler handler) {
        m2841a(new RunnableC0651w(this, handler));
    }

    @Override // com.sec.chaton.p015d.AbstractC0531a
    /* renamed from: a */
    public void mo2703a(String str) {
        m2841a(new RunnableC0653y(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p015d.AbstractC0630b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo2796a(IBinder iBinder) {
        return IPushClientService.Stub.asInterface(iBinder);
    }
}
