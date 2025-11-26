package com.sec.common.util.p133a;

import java.util.concurrent.ThreadFactory;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.common.util.a.b */
/* loaded from: classes.dex */
class ThreadFactoryC5018b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C5017a f18313a;

    ThreadFactoryC5018b(C5017a c5017a) {
        this.f18313a = c5017a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "FileDownloadThread");
        thread.setPriority(1);
        return thread;
    }
}
