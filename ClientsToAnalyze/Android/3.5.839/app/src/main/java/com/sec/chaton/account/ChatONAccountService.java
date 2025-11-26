package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONAccountService extends Service {

    /* renamed from: a */
    private static ServiceConnectionC0996c f3250a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C4904y.m18646e("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18646e("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        return m6040b().getIBinder();
    }

    /* renamed from: b */
    private ServiceConnectionC0996c m6040b() {
        if (f3250a == null) {
            f3250a = new ServiceConnectionC0996c(getApplicationContext());
        }
        return f3250a;
    }
}
