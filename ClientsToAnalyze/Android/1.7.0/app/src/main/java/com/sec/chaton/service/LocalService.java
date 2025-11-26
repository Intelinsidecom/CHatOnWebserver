package com.sec.chaton.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class LocalService extends BaseService {

    /* renamed from: c */
    private final IBinder f3394c = new BinderC0997b(this);

    /* renamed from: d */
    private final Lock f3395d = new ReentrantLock();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m3764a();
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo3765a(Intent intent, int i) {
        if (intent != null) {
            Message messageObtainMessage = m3768c().obtainMessage();
            messageObtainMessage.what = i;
            messageObtainMessage.obj = intent;
            m3768c().sendMessage(messageObtainMessage);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m3767b();
    }

    @Override // com.sec.chaton.service.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f3394c;
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo3766a(Message message) {
        int i = message.what;
    }
}
