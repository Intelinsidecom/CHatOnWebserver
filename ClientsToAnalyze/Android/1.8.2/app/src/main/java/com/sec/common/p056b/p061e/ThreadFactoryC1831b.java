package com.sec.common.p056b.p061e;

import java.util.concurrent.ThreadFactory;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.common.b.e.b */
/* loaded from: classes.dex */
class ThreadFactoryC1831b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C1830a f6553a;

    ThreadFactoryC1831b(C1830a c1830a) {
        this.f6553a = c1830a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "FileDownloadThread");
        thread.setPriority(1);
        return thread;
    }
}
