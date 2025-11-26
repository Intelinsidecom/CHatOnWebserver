package com.sec.chaton.settings;

import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentFontChange.java */
/* renamed from: com.sec.chaton.settings.eg */
/* loaded from: classes.dex */
class ThreadFactoryC3597eg implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentFontChange f13124a;

    ThreadFactoryC3597eg(FragmentFontChange fragmentFontChange) {
        this.f13124a = fragmentFontChange;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentFontChange.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
