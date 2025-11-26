package com.sec.chaton.settings;

import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.dz */
/* loaded from: classes.dex */
class ThreadFactoryC2662dz implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f9929a;

    ThreadFactoryC2662dz(FragmentSkinChange3 fragmentSkinChange3) {
        this.f9929a = fragmentSkinChange3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentSkinChange3.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
