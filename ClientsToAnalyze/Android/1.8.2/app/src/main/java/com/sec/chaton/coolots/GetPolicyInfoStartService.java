package com.sec.chaton.coolots;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class GetPolicyInfoStartService extends Service {

    /* renamed from: a */
    private static final String f2133a = GetPolicyInfoStartService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2133a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2133a, "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Log.i(f2133a, "onStart " + i);
        if (!new C0527g(this, new C0528h(this)).m2698a()) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
