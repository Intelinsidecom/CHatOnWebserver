package com.sec.common.p132g;

import java.util.concurrent.ThreadFactory;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.g.d */
/* loaded from: classes.dex */
class ThreadFactoryC5008d implements ThreadFactory {
    ThreadFactoryC5008d() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, C5007c.f18269c);
        thread.setPriority(1);
        return thread;
    }
}
