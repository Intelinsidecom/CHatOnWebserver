package com.sec.chaton.push;

import android.app.Application;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.network.connection.ProvConnectionManager;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.PushLog;
import com.sec.chaton.push.util.ServiceUtil;

/* loaded from: classes.dex */
public class PushClientApplication extends Application {

    /* renamed from: a */
    private static final String f2588a = PushClientApplication.class.getSimpleName();

    /* renamed from: b */
    private boolean f2589b;

    /* renamed from: c */
    private PushConnectionManager f2590c;

    /* renamed from: d */
    private ProvConnectionManager f2591d;

    /* renamed from: a */
    public void m2856a(boolean z) {
        this.f2589b = z;
    }

    /* renamed from: a */
    public boolean m2857a() {
        return this.f2589b;
    }

    /* renamed from: b */
    public PushConnectionManager m2858b() {
        return this.f2590c;
    }

    /* renamed from: c */
    public ProvConnectionManager m2859c() {
        return this.f2591d;
    }

    @Override // android.app.Application
    public void onCreate() {
        PushLog.m3025a(f2588a, "PushClientApplication.onCreate()");
        PushLog.m3028b(f2588a, "PushModule version: 0.5.2");
        super.onCreate();
        if (ServiceUtil.m3040a(this)) {
            PushLog.m3025a(f2588a, "Discovered public push client. disable in app push client.");
            ServiceUtil.m3039a(this, false);
        } else {
            PushLog.m3025a(f2588a, "Couldn't discover public push client. enable in app push client.");
            ServiceUtil.m3041b(this, false);
        }
        this.f2589b = false;
        this.f2591d = new ProvConnectionManager(this);
        this.f2590c = new PushConnectionManager(this);
        AlarmTimer.m3016a().m3017a(getApplicationContext());
        MessageController.m2911p().m2916a(getApplicationContext(), this.f2591d, this.f2590c);
    }

    @Override // android.app.Application
    public void onTerminate() {
        PushLog.m3025a(f2588a, "PushClientApplication.onTerminate()");
        super.onTerminate();
    }
}
