package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONSyncServiceAdapter extends Service {

    /* renamed from: a */
    private static final Object f1461a = new Object();

    /* renamed from: b */
    private static C0421g f1462b = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (f1461a) {
            if (f1462b == null) {
                f1462b = new C0421g(getApplicationContext());
            }
        }
        C3250y.m11453c("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder syncAdapterBinder;
        synchronized (f1461a) {
            syncAdapterBinder = f1462b.getSyncAdapterBinder();
        }
        return syncAdapterBinder;
    }
}
