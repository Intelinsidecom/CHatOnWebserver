package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.al */
/* loaded from: classes.dex */
class HandlerC2545al extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9691a;

    HandlerC2545al(AniconPackageDownloads aniconPackageDownloads) {
        this.f9691a = aniconPackageDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == C2556aw.f9709b) {
            int i = message.arg1;
            if (this.f9691a.f9487i != null) {
                this.f9691a.m9336b(i == C2556aw.f9711d);
            }
        }
        super.handleMessage(message);
    }
}
