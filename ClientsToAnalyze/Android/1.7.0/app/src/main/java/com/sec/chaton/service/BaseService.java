package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public abstract class BaseService extends Service {

    /* renamed from: a */
    protected volatile HandlerC0996a f3392a;

    /* renamed from: b */
    protected volatile Looper f3393b;

    /* renamed from: a */
    protected abstract void mo3765a(Intent intent, int i);

    /* renamed from: a */
    protected abstract void mo3766a(Message message);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        mo3765a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        mo3765a(intent, i2);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    protected void m3764a() {
        HandlerThread handlerThread = new HandlerThread("ChatON-Service");
        handlerThread.start();
        this.f3393b = handlerThread.getLooper();
        this.f3392a = new HandlerC0996a(this, this.f3393b);
    }

    /* renamed from: b */
    protected void m3767b() {
        this.f3393b.quit();
    }

    /* renamed from: c */
    protected HandlerC0996a m3768c() {
        return this.f3392a;
    }
}
