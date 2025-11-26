package com.sec.chaton.coolots;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class CreateAccountStartService extends Service {

    /* renamed from: a */
    private static final String f2132a = CreateAccountStartService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2132a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2132a, "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Log.i(f2132a, "onStart " + i);
        if (!new C0524d(this, new C0525e(this)).m2698a()) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
