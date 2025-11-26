package com.sec.chaton.global;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.global.a */
/* loaded from: classes.dex */
class ServiceConnectionC0237a implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f1905a;

    ServiceConnectionC0237a(GlobalApplication globalApplication) {
        this.f1905a = globalApplication;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ChatONLogWriter.m3508c("onServiceConnected : SPP", getClass().getSimpleName());
        this.f1905a.f1903j = IPushClientService.Stub.m2854a(iBinder);
        this.f1905a.f1902i = 2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ChatONLogWriter.m3508c("OnServiceDisConnected : SPP", getClass().getSimpleName());
        this.f1905a.f1902i = 0;
        this.f1905a.f1903j = null;
    }
}
