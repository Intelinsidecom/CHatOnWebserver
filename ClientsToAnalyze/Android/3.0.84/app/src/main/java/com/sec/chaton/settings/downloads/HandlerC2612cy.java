package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.cy */
/* loaded from: classes.dex */
class HandlerC2612cy extends Handler {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9837a;

    HandlerC2612cy(SoundDownloads soundDownloads) {
        this.f9837a = soundDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == C2556aw.f9709b) {
            this.f9837a.m9416a(message.arg1 == C2556aw.f9711d);
        }
        super.handleMessage(message);
    }
}
