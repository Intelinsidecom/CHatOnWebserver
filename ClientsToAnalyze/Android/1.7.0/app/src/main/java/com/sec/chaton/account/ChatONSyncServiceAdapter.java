package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ChatONSyncServiceAdapter extends Service {

    /* renamed from: a */
    private static final Object f571a = new Object();

    /* renamed from: b */
    private static C0237f f572b = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (f571a) {
            if (f572b == null) {
                f572b = new C0237f(getApplicationContext());
            }
        }
        C1341p.m4660c("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder syncAdapterBinder;
        synchronized (f571a) {
            syncAdapterBinder = f572b.getSyncAdapterBinder();
        }
        return syncAdapterBinder;
    }
}
