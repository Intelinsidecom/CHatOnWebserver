package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: PushRegistrationService.java */
/* renamed from: com.sec.chaton.service.h */
/* loaded from: classes.dex */
class HandlerC3421h extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushRegistrationService f12435a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3421h(PushRegistrationService pushRegistrationService, Looper looper) {
        super(looper);
        this.f12435a = pushRegistrationService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((Boolean) message.obj).booleanValue()) {
            C4904y.m18639b("Success push registration. execute get version with push", PushRegistrationService.f12425a);
            this.f12435a.m13294c();
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity")).getActiveNetworkInfo();
        C4904y.m18639b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), PushRegistrationService.f12425a);
        GlobalApplication.f8355a = null;
        this.f12435a.f12426b = false;
        this.f12435a.stopSelf();
    }
}
