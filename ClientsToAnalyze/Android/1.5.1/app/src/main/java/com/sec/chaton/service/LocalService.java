package com.sec.chaton.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class LocalService extends BaseService {

    /* renamed from: c */
    private final IBinder f2966c = new LocalBinder();

    /* renamed from: d */
    private final Lock f2967d = new ReentrantLock();

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo3115a(Intent intent, int i) {
        if (intent == null) {
            return;
        }
        Message messageObtainMessage = m3118c().obtainMessage();
        messageObtainMessage.what = i;
        messageObtainMessage.obj = intent;
        m3118c().sendMessage(messageObtainMessage);
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo3116a(Message message) {
        int i = message.what;
    }

    @Override // com.sec.chaton.service.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2966c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m3114a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m3117b();
    }
}
