package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ChatONAccountService extends Service {

    /* renamed from: a */
    private static ServiceConnectionC0205b f733a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1786r.m6066e("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1786r.m6066e("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        return m1801a().getIBinder();
    }

    /* renamed from: a */
    private ServiceConnectionC0205b m1801a() {
        if (f733a == null) {
            f733a = new ServiceConnectionC0205b(getApplicationContext());
        }
        return f733a;
    }
}
