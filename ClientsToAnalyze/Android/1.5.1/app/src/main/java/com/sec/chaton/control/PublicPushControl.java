package com.sec.chaton.control;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.spp.push.IPushClientService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PublicPushControl extends AbstractPushControl {

    /* renamed from: c */
    private static final String f1381c = PublicPushControl.class.getSimpleName();

    /* renamed from: d */
    private static PublicPushControl f1382d;

    /* renamed from: e */
    private Map f1383e;

    /* renamed from: f */
    private C0207v f1384f;

    private PublicPushControl() {
        super("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");
        this.f1383e = new HashMap();
        this.f1384f = new C0207v(this);
        GlobalApplication.m2387e().registerReceiver(this.f1384f, new IntentFilter("com.sec.spp.RegistrationChangedAction"));
    }

    /* renamed from: a */
    public static PublicPushControl m2067a() {
        if (f1382d == null) {
            f1382d = new PublicPushControl();
        }
        return f1382d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.control.AbstractServiceWrapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo1985b(IBinder iBinder) {
        return IPushClientService.Stub.m3704a(iBinder);
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: a */
    public void mo1974a(Handler handler) {
        m1984a(new RunnableC0176e(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: a */
    public void mo1975a(String str) {
        m1984a(new RunnableC0180i(this, str));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: b */
    public void mo1976b(Handler handler) {
        m1984a(new RunnableC0173b(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: c */
    public void mo1977c(Handler handler) {
        m1984a(new RunnableC0182k(this, handler));
    }

    @Override // com.sec.chaton.control.AbstractPushControl
    /* renamed from: d */
    public void mo1978d(Handler handler) {
        m1984a(new RunnableC0206u(this, handler));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        GlobalApplication.m2387e().unregisterReceiver(this.f1384f);
    }
}
