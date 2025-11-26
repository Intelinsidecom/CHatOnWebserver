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
    protected volatile HandlerC1215a f4431a;

    /* renamed from: b */
    protected volatile Looper f4432b;

    /* renamed from: a */
    protected abstract void mo4464a(Intent intent, int i);

    /* renamed from: a */
    protected abstract void mo4465a(Message message);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        mo4464a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        mo4464a(intent, i2);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    protected void m4463a() {
        HandlerThread handlerThread = new HandlerThread("ChatON-Service");
        handlerThread.start();
        this.f4432b = handlerThread.getLooper();
        this.f4431a = new HandlerC1215a(this, this.f4432b);
    }

    /* renamed from: b */
    protected void m4466b() {
        this.f4432b.quit();
    }

    /* renamed from: c */
    protected HandlerC1215a m4467c() {
        return this.f4431a;
    }
}
