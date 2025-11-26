package com.sec.common.util.log.collector;

import java.util.concurrent.ThreadFactory;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.i */
/* loaded from: classes.dex */
class ThreadFactoryC5044i implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C5043h f18378a;

    ThreadFactoryC5044i(C5043h c5043h) {
        this.f18378a = c5043h;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }
}
