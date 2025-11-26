package com.sec.chaton.for3rd;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes.dex */
public class DataAccessService extends Service {

    /* renamed from: a */
    private static final String f2742a = DataAccessService.class.getSimpleName();

    /* renamed from: b */
    private AbstractBinderC0747d f2743b = new BinderC0745b(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2742a, "tid" + Thread.currentThread().getId() + " onCreate, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2742a, "tid" + Thread.currentThread().getId() + " onDestroy");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(f2742a, "tid" + Thread.currentThread().getId() + " onBind, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid());
        return this.f2743b;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(f2742a, "tid" + Thread.currentThread().getId() + " onRebind");
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.i(f2742a, "tid" + Thread.currentThread().getId() + " onUnbind " + intent);
        return super.onUnbind(intent);
    }
}
