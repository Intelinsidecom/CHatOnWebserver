package com.sec.chaton.smsplugin.p102b;

/* compiled from: Contact.java */
/* renamed from: com.sec.chaton.smsplugin.b.f */
/* loaded from: classes.dex */
class RunnableC3787f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3786e f13586a;

    RunnableC3787f(C3786e c3786e) {
        this.f13586a = c3786e;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            Runnable runnable = null;
            synchronized (this.f13586a.f13585b) {
                if (this.f13586a.f13585b.size() == 0) {
                    try {
                        this.f13586a.f13585b.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if (this.f13586a.f13585b.size() > 0) {
                    runnable = (Runnable) this.f13586a.f13585b.remove(0);
                }
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
