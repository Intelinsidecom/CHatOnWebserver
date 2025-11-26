package com.sec.common.p056b.p059c;

import java.util.concurrent.ThreadFactory;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.b.c.c */
/* loaded from: classes.dex */
class ThreadFactoryC1822c implements ThreadFactory {
    ThreadFactoryC1822c() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, C1821b.f6526c);
        thread.setPriority(1);
        return thread;
    }
}
