package com.sec.chaton.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class LocalService extends BaseService {

    /* renamed from: c */
    private final IBinder f4433c = new BinderC1216b(this);

    /* renamed from: d */
    private final Lock f4434d = new ReentrantLock();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m4463a();
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo4464a(Intent intent, int i) {
        if (intent != null) {
            Message messageObtainMessage = m4467c().obtainMessage();
            messageObtainMessage.what = i;
            messageObtainMessage.obj = intent;
            m4467c().sendMessage(messageObtainMessage);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m4466b();
    }

    @Override // com.sec.chaton.service.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4433c;
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo4465a(Message message) {
        int i = message.what;
    }
}
