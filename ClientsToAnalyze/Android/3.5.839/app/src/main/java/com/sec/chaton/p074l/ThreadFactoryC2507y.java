package com.sec.chaton.p074l;

import java.util.concurrent.ThreadFactory;

/* compiled from: ProfileImageManager.java */
/* renamed from: com.sec.chaton.l.y */
/* loaded from: classes.dex */
class ThreadFactoryC2507y implements ThreadFactory {
    ThreadFactoryC2507y() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, C2496n.f8947b);
    }
}
