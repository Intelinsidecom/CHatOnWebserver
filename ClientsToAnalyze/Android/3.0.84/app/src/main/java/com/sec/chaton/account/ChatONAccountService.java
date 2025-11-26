package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONAccountService extends Service {

    /* renamed from: a */
    private static ServiceConnectionC0417c f1460a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C3250y.m11456e("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11456e("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        return m3022b().getIBinder();
    }

    /* renamed from: b */
    private ServiceConnectionC0417c m3022b() {
        if (f1460a == null) {
            f1460a = new ServiceConnectionC0417c(getApplicationContext());
        }
        return f1460a;
    }
}
