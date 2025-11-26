package com.sec.chaton.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;

/* loaded from: classes.dex */
public class LocalService extends BaseService {

    /* renamed from: c */
    private final IBinder f12424c = new BinderC3419f(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m13278a();
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo13279a(Intent intent, int i) {
        if (intent != null) {
            Message messageObtainMessage = m13282c().obtainMessage();
            messageObtainMessage.what = i;
            messageObtainMessage.obj = intent;
            m13282c().sendMessage(messageObtainMessage);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m13281b();
    }

    @Override // com.sec.chaton.service.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12424c;
    }

    @Override // com.sec.chaton.service.BaseService
    /* renamed from: a */
    protected void mo13280a(Message message) {
    }
}
