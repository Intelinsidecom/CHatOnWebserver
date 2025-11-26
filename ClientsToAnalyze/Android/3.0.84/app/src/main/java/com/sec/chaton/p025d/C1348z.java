package com.sec.chaton.p025d;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import com.sec.spp.push.IPushClientService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.z */
/* loaded from: classes.dex */
public class C1348z extends AbstractC1144a<IPushClientService> {

    /* renamed from: c */
    private static final String f5083c = C1348z.class.getSimpleName();

    /* renamed from: d */
    private static C1348z f5084d;

    /* renamed from: e */
    private Map<Integer, Handler> f5085e;

    /* renamed from: f */
    private C1292ae f5086f;

    private C1348z() {
        super("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");
        this.f5085e = new HashMap();
        this.f5086f = new C1292ae(this);
        CommonApplication.m11493l().registerReceiver(this.f5086f, new IntentFilter(Config.PUSH_REGISTRATION_CHANGED_ACTION));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        CommonApplication.m11493l().unregisterReceiver(this.f5086f);
    }

    /* renamed from: e */
    public static C1348z m5947e() {
        if (f5084d == null) {
            f5084d = new C1348z();
        }
        return f5084d;
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: a */
    public void mo5479a(Handler handler) {
        m5667a(new RunnableC1293af(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: b */
    public void mo5481b(Handler handler) {
        m5667a(new RunnableC1288aa(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: c */
    public void mo5482c(Handler handler) {
        m5667a(new RunnableC1290ac(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: d */
    public void mo5483d(Handler handler) {
        m5667a(new RunnableC1289ab(this, handler));
    }

    @Override // com.sec.chaton.p025d.AbstractC1144a
    /* renamed from: a */
    public void mo5480a(String str) {
        m5667a(new RunnableC1291ad(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p025d.AbstractC1314b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo5586a(IBinder iBinder) {
        return IPushClientService.Stub.asInterface(iBinder);
    }
}
