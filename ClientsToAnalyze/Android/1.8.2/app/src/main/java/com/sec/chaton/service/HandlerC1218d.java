package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.d */
/* loaded from: classes.dex */
class HandlerC1218d extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f4441a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1218d(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f4441a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((Boolean) message.obj).booleanValue()) {
            C1786r.m6061b("Success push registration. execute get version with push", PushRegistrationService.f4435a);
            this.f4441a.m4473c();
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m3260b().getSystemService("connectivity")).getActiveNetworkInfo();
        C1786r.m6061b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), PushRegistrationService.f4435a);
        GlobalApplication.f2775a = null;
        this.f4441a.f4436b = false;
        this.f4441a.stopSelf();
    }
}
