package com.sec.chaton.for3rd;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class DataAccessService extends Service {

    /* renamed from: a */
    private static final String f2389a = DataAccessService.class.getSimpleName();

    /* renamed from: b */
    private AbstractBinderC0705b f2390b = new BinderC0706c(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " onCreate, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), f2389a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " onDestroy, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), f2389a);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " onBind, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), f2389a);
        return this.f2390b;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " onRebind, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), f2389a);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " onUnbind, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), f2389a);
        return super.onUnbind(intent);
    }
}
