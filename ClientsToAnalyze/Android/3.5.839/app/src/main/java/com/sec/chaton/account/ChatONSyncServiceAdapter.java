package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONSyncServiceAdapter extends Service {

    /* renamed from: a */
    private static final Object f3251a = new Object();

    /* renamed from: b */
    private static C1000g f3252b = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (f3251a) {
            if (f3252b == null) {
                f3252b = new C1000g(getApplicationContext());
            }
        }
        C4904y.m18641c("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder syncAdapterBinder;
        synchronized (f3251a) {
            syncAdapterBinder = f3252b.getSyncAdapterBinder();
        }
        return syncAdapterBinder;
    }
}
