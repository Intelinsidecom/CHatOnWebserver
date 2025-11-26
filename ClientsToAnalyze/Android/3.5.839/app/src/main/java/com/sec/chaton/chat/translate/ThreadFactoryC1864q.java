package com.sec.chaton.chat.translate;

import java.util.concurrent.ThreadFactory;

/* compiled from: TranslateExecutor.java */
/* renamed from: com.sec.chaton.chat.translate.q */
/* loaded from: classes.dex */
class ThreadFactoryC1864q implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C1863p f7082a;

    ThreadFactoryC1864q(C1863p c1863p) {
        this.f7082a = c1863p;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "TranslateExecutor");
    }
}
