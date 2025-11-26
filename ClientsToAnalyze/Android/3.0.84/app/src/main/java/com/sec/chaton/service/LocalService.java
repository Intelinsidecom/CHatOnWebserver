package com.sec.chaton.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;

/* loaded from: classes.dex */
public class LocalService extends BaseService {

    /* renamed from: c */
    private final IBinder f8894c = new BinderC2391f(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m8894a();
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo8895a(Intent intent, int i) {
        if (intent != null) {
            Message messageObtainMessage = m8898c().obtainMessage();
            messageObtainMessage.what = i;
            messageObtainMessage.obj = intent;
            m8898c().sendMessage(messageObtainMessage);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m8897b();
    }

    @Override // com.sec.chaton.service.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f8894c;
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo8896a(Message message) {
    }
}
