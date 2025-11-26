package com.sec.common.p069e;

import java.util.concurrent.ThreadFactory;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.e.d */
/* loaded from: classes.dex */
class ThreadFactoryC3327d implements ThreadFactory {
    ThreadFactoryC3327d() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, C3326c.f12020c);
        thread.setPriority(1);
        return thread;
    }
}
