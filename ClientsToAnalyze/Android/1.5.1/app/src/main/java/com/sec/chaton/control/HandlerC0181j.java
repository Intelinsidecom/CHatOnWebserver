package com.sec.chaton.control;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.j */
/* loaded from: classes.dex */
class HandlerC0181j extends Handler {

    /* renamed from: a */
    final /* synthetic */ VersionControl f1420a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0181j(VersionControl versionControl, Looper looper) {
        super(looper);
        this.f1420a = versionControl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!((Boolean) message.obj).booleanValue()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m2387e().getSystemService("connectivity")).getActiveNetworkInfo();
            ChatONLogWriter.m3506b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "VersionControl");
        }
        this.f1420a.m2094a();
    }
}
