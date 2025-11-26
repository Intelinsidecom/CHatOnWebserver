package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.g */
/* loaded from: classes.dex */
class HandlerC2632g extends Handler {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9875a;

    HandlerC2632g(AmsItemDownloads amsItemDownloads) {
        this.f9875a = amsItemDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == C2556aw.f9709b) {
            int i = message.arg1;
            if (this.f9875a.f9444p != null) {
                this.f9875a.m9307a(i == C2556aw.f9711d);
            }
        }
        super.handleMessage(message);
    }
}
