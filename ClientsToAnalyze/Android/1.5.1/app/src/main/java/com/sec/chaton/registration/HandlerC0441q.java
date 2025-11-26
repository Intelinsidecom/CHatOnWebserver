package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.q */
/* loaded from: classes.dex */
class HandlerC0441q extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f2954a;

    HandlerC0441q(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f2954a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue() && !((Boolean) message.obj).booleanValue()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2954a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            ChatONLogWriter.m3506b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
        }
        this.f2954a.f2836c.m2076a(this.f2954a.f2839f, this.f2954a.f2840g, "", "");
    }
}
