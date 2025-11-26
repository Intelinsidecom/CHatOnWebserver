package com.sec.chaton.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;

/* loaded from: classes.dex */
public class PushClientService extends Service {

    /* renamed from: a */
    private final String f2592a = PushClientService.class.getSimpleName();

    /* renamed from: b */
    private IPushClientService.Stub f2593b = new BinderC0357e(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        PushLog.m3025a(this.f2592a, "PushClientService.onBind()");
        return this.f2593b;
    }

    @Override // android.app.Service
    public void onCreate() {
        PushLog.m3025a(this.f2592a, "PushClientService.onCreate()");
        super.onCreate();
        getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }

    @Override // android.app.Service
    public void onDestroy() {
        PushLog.m3025a(this.f2592a, "PushClientService.onDestroy()");
        super.onDestroy();
        PushClientApplication pushClientApplication = (PushClientApplication) getApplication();
        pushClientApplication.m2856a(false);
        HeartBeat.m2874b(getApplicationContext());
        try {
            pushClientApplication.m2859c().m2982b();
        } catch (ConnectionException e) {
        }
        try {
            pushClientApplication.m2858b().m2982b();
        } catch (ConnectionException e2) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        PushLog.m3025a(this.f2592a, "PushClientService is started");
        super.onStartCommand(intent, i, i2);
        ((PushClientApplication) getApplication()).m2856a(true);
        if (RegistrationManager.m3012b(this) != null) {
            MessageController.m2911p().m2914a().post(new RunnableC0356d(this));
            return 1;
        }
        PushLog.m3028b(this.f2592a, "The registered application doesn't exist in push module. Don't try to execute initalize.");
        stopSelf();
        return 2;
    }
}
