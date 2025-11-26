package com.sec.chaton.coolots;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class GetPolicyInfoStartService extends Service {

    /* renamed from: a */
    private static final String f2145a = GetPolicyInfoStartService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2145a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2145a, "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Log.i(f2145a, "onStart " + i);
        if (!new C0610a(this, new C0618i(this)).m2832b()) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
