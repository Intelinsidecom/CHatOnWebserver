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
    protected volatile HandlerC2389d f8885a;

    /* renamed from: b */
    protected volatile Looper f8886b;

    /* renamed from: a */
    protected abstract void mo8895a(Intent intent, int i);

    /* renamed from: a */
    protected abstract void mo8896a(Message message);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        mo8895a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        mo8895a(intent, i2);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    protected void m8894a() {
        HandlerThread handlerThread = new HandlerThread("ChatON-Service");
        handlerThread.start();
        this.f8886b = handlerThread.getLooper();
        this.f8885a = new HandlerC2389d(this, this.f8886b);
    }

    /* renamed from: b */
    protected void m8897b() {
        this.f8886b.quit();
    }

    /* renamed from: c */
    protected HandlerC2389d m8898c() {
        return this.f8885a;
    }
}
