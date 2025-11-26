package com.sec.p007b.p008a.p011c;

import java.util.concurrent.ThreadFactory;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.b.a.c.c */
/* loaded from: classes.dex */
class ThreadFactoryC0118c implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C0119d f219a;

    ThreadFactoryC0118c(C0119d c0119d) {
        this.f219a = c0119d;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, C0119d.f220c);
        thread.setPriority(1);
        return thread;
    }
}
