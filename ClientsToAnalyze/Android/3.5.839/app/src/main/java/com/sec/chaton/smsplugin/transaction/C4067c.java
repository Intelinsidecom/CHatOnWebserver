package com.sec.chaton.smsplugin.transaction;

import java.io.IOException;

/* compiled from: BackgroundSenderService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.c */
/* loaded from: classes.dex */
class C4067c extends Thread {

    /* renamed from: a */
    final /* synthetic */ C4066b f14666a;

    C4067c(C4066b c4066b) {
        this.f14666a = c4066b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.f14666a.m15658b();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
