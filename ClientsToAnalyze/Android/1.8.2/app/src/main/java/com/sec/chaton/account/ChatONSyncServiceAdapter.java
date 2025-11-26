package com.sec.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ChatONSyncServiceAdapter extends Service {

    /* renamed from: a */
    private static final Object f734a = new Object();

    /* renamed from: b */
    private static C0208e f735b = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (f734a) {
            if (f735b == null) {
                f735b = new C0208e(getApplicationContext());
            }
        }
        C1786r.m6063c("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1786r.m6063c("onDestroy", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder syncAdapterBinder;
        synchronized (f734a) {
            syncAdapterBinder = f735b.getSyncAdapterBinder();
        }
        return syncAdapterBinder;
    }
}
