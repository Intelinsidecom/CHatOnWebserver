package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.h */
/* loaded from: classes.dex */
class HandlerC2393h extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f8905a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2393h(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f8905a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((Boolean) message.obj).booleanValue()) {
            C3250y.m11450b("Success push registration. execute get version with push", PushRegistrationService.f8895a);
            this.f8905a.m8908c();
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m11493l().getSystemService("connectivity")).getActiveNetworkInfo();
        C3250y.m11450b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), PushRegistrationService.f8895a);
        GlobalApplication.f5511a = null;
        this.f8905a.f8896b = false;
        this.f8905a.stopSelf();
    }
}
