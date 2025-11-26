package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public abstract class BaseService extends Service {

    /* renamed from: a */
    protected volatile LocalServiceHandler f2963a;

    /* renamed from: b */
    protected volatile Looper f2964b;

    public final class LocalServiceHandler extends Handler {
        public LocalServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseService.this.mo3116a(message);
        }
    }

    /* renamed from: a */
    protected void m3114a() {
        HandlerThread handlerThread = new HandlerThread("ChatON-Service");
        handlerThread.start();
        this.f2964b = handlerThread.getLooper();
        this.f2963a = new LocalServiceHandler(this.f2964b);
    }

    /* renamed from: a */
    protected abstract void mo3115a(Intent intent, int i);

    /* renamed from: a */
    protected abstract void mo3116a(Message message);

    /* renamed from: b */
    protected void m3117b() {
        this.f2964b.quit();
    }

    /* renamed from: c */
    protected LocalServiceHandler m3118c() {
        return this.f2963a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        mo3115a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        mo3115a(intent, i2);
        return 1;
    }
}
