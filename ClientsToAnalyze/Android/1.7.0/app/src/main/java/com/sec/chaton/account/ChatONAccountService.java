package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ChatONAccountService extends Service {

    /* renamed from: a */
    private static ServiceConnectionC0236e f570a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1341p.m4662e("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1341p.m4662e("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        return m893a().getIBinder();
    }

    /* renamed from: a */
    private ServiceConnectionC0236e m893a() {
        if (f570a == null) {
            f570a = new ServiceConnectionC0236e(getApplicationContext());
        }
        return f570a;
    }
}
