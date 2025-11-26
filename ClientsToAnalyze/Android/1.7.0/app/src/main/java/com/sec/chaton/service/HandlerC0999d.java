package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.d */
/* loaded from: classes.dex */
class HandlerC0999d extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f3402a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0999d(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f3402a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((Boolean) message.obj).booleanValue()) {
            C1341p.m4658b("Success push registration. execute get version with push", PushRegistrationService.f3396a);
            this.f3402a.m3774c();
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m3100a().getSystemService("connectivity")).getActiveNetworkInfo();
        C1341p.m4658b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), PushRegistrationService.f3396a);
        GlobalApplication.f2407a = null;
        this.f3402a.f3397b = false;
        this.f3402a.stopSelf();
    }
}
