package com.sec.chaton.settings;

import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.ev */
/* loaded from: classes.dex */
class ThreadFactoryC3612ev implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f13145a;

    ThreadFactoryC3612ev(FragmentSkinChange3 fragmentSkinChange3) {
        this.f13145a = fragmentSkinChange3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentSkinChange3.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
