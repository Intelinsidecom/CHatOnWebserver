package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask.java */
/* renamed from: android.support.v4.content.n */
/* loaded from: classes.dex */
final class ThreadFactoryC0101n implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f338a = new AtomicInteger(1);

    ThreadFactoryC0101n() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.f338a.getAndIncrement());
    }
}
