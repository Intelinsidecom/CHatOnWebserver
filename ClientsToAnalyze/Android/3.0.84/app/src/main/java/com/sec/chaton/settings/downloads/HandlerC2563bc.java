package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.bc */
/* loaded from: classes.dex */
class HandlerC2563bc extends Handler {

    /* renamed from: a */
    final /* synthetic */ FontDownloads f9742a;

    HandlerC2563bc(FontDownloads fontDownloads) {
        this.f9742a = fontDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == C2556aw.f9709b) {
            int i = message.arg1;
            if (this.f9742a.f9531j != null) {
                this.f9742a.m9363b(i == C2556aw.f9711d);
            }
        }
        super.handleMessage(message);
    }
}
