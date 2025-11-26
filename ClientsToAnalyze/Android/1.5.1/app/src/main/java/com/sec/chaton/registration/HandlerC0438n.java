package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.n */
/* loaded from: classes.dex */
class HandlerC0438n extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2951a;

    HandlerC0438n(ActivityNonSelfSMS activityNonSelfSMS) {
        this.f2951a = activityNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue() && !((Boolean) message.obj).booleanValue()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2951a.getSystemService("connectivity")).getActiveNetworkInfo();
            ChatONLogWriter.m3506b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
        }
        this.f2951a.f2830w.m2076a(this.f2951a.f2827t, this.f2951a.f2832y, this.f2951a.f2808a == null ? null : this.f2951a.f2808a.token, this.f2951a.f2811d);
    }
}
