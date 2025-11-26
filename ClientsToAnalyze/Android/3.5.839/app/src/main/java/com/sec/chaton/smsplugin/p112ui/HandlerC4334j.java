package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: ClassZeroActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.j */
/* loaded from: classes.dex */
class HandlerC4334j extends Handler {

    /* renamed from: a */
    final /* synthetic */ ClassZeroActivity f15764a;

    HandlerC4334j(ClassZeroActivity classZeroActivity) {
        this.f15764a = classZeroActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.f15764a.f14749d = false;
            this.f15764a.f14751f.dismiss();
            this.f15764a.m15741a();
            this.f15764a.finish();
        }
    }
}
