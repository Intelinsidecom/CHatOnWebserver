package com.sec.chaton.smsplugin.spam;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.as */
/* loaded from: classes.dex */
class HandlerC3988as extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14429a;

    HandlerC3988as(SetupSpamNumberList setupSpamNumberList) {
        this.f14429a = setupSpamNumberList;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C3847e.m14651aB() && this.f14429a.f14362S != null) {
            this.f14429a.f14362S.dismiss();
            this.f14429a.f14362S = null;
        }
    }
}
