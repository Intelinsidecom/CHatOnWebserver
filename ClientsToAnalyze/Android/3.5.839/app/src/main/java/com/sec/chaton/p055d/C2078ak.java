package com.sec.chaton.p055d;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import com.sec.spp.push.IPushClientService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ak */
/* loaded from: classes.dex */
public class C2078ak extends AbstractC1899a<IPushClientService> {

    /* renamed from: c */
    private static final String f7576c = C2078ak.class.getSimpleName();

    /* renamed from: d */
    private static C2078ak f7577d;

    /* renamed from: e */
    private Map<Integer, Handler> f7578e;

    /* renamed from: f */
    private C2083ap f7579f;

    private C2078ak() {
        super("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");
        this.f7578e = new HashMap();
        this.f7579f = new C2083ap(this);
        CommonApplication.m18732r().registerReceiver(this.f7579f, new IntentFilter(Config.PUSH_REGISTRATION_CHANGED_ACTION));
    }

    protected void finalize() throws Throwable {
        super.finalize();
        CommonApplication.m18732r().unregisterReceiver(this.f7579f);
    }

    /* renamed from: e */
    public static C2078ak m9325e() {
        if (f7577d == null) {
            f7577d = new C2078ak();
        }
        return f7577d;
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: a */
    public void mo9077a(Handler handler) {
        try {
            m9345a(new RunnableC2084aq(this, handler));
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7576c);
            }
            if (handler != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                handler.sendMessage(message);
            }
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: b */
    public void mo9079b(Handler handler) {
        try {
            m9345a(new RunnableC2079al(this, handler));
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7576c);
            }
            if (handler != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                handler.sendMessage(message);
            }
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: c */
    public void mo9080c(Handler handler) {
        try {
            m9345a(new RunnableC2081an(this, handler));
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7576c);
            }
            if (handler != null) {
                Message message = new Message();
                message.what = 1003;
                message.obj = false;
                handler.sendMessage(message);
            }
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: d */
    public void mo9081d(Handler handler) {
        try {
            m9345a(new RunnableC2080am(this, handler));
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7576c);
            }
            if (handler != null) {
                Message message = new Message();
                message.what = 1004;
                message.obj = null;
                handler.sendMessage(message);
            }
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC1899a
    /* renamed from: a */
    public void mo9078a(String str) {
        try {
            m9345a(new RunnableC2082ao(this, str));
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7576c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p055d.AbstractC2094b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IPushClientService mo9327a(IBinder iBinder) {
        return IPushClientService.Stub.asInterface(iBinder);
    }
}
