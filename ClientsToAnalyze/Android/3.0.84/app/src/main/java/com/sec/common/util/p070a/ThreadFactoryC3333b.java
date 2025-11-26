package com.sec.common.util.p070a;

import java.util.concurrent.ThreadFactory;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.common.util.a.b */
/* loaded from: classes.dex */
class ThreadFactoryC3333b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C3332a f12048a;

    ThreadFactoryC3333b(C3332a c3332a) {
        this.f12048a = c3332a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "FileDownloadThread");
        thread.setPriority(1);
        return thread;
    }
}
