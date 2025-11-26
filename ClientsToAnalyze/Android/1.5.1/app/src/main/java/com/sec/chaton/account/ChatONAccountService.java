package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ChatONAccountService extends Service {

    /* renamed from: a */
    private static ServiceConnectionC0067d f325a = null;

    /* renamed from: a */
    private ServiceConnectionC0067d m399a() {
        if (f325a == null) {
            f325a = new ServiceConnectionC0067d(getApplicationContext());
        }
        return f325a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return m399a().getIBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ChatONLogWriter.m3511e("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3511e("onDestroy", getClass().getSimpleName());
    }
}
