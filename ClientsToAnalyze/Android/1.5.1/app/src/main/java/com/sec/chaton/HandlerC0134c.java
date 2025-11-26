package com.sec.chaton;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.control.VersionControl;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.c */
/* loaded from: classes.dex */
class HandlerC0134c extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f720a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0134c(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f720a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((Boolean) message.obj).booleanValue()) {
            ChatONLogWriter.m3506b("Success push registration. execute get version with push", HomeActivity.class.getSimpleName());
            new VersionControl(this.f720a.f294d).m2095b();
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m2387e().getSystemService("connectivity")).getActiveNetworkInfo();
            ChatONLogWriter.m3506b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "VersionControl");
        }
    }
}
