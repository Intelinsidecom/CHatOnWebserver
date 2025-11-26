package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Settings.java */
/* renamed from: com.facebook.bv */
/* loaded from: classes.dex */
final class ThreadFactoryC0128bv implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f277a = new AtomicInteger(0);

    ThreadFactoryC0128bv() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FacebookSdk #" + this.f277a.incrementAndGet());
    }
}
