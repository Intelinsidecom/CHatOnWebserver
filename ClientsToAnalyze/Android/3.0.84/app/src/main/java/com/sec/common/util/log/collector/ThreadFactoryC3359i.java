package com.sec.common.util.log.collector;

import java.util.concurrent.ThreadFactory;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.i */
/* loaded from: classes.dex */
class ThreadFactoryC3359i implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C3358h f12107a;

    ThreadFactoryC3359i(C3358h c3358h) {
        this.f12107a = c3358h;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }
}
