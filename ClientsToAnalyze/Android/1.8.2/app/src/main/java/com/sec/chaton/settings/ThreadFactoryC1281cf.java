package com.sec.chaton.settings;

import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.cf */
/* loaded from: classes.dex */
class ThreadFactoryC1281cf implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f4827a;

    ThreadFactoryC1281cf(FragmentSkinChange2 fragmentSkinChange2) {
        this.f4827a = fragmentSkinChange2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentSkinChange2.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
