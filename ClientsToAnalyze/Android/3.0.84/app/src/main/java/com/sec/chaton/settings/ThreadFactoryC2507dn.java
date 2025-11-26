package com.sec.chaton.settings;

import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentFontChange.java */
/* renamed from: com.sec.chaton.settings.dn */
/* loaded from: classes.dex */
class ThreadFactoryC2507dn implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentFontChange f9403a;

    ThreadFactoryC2507dn(FragmentFontChange fragmentFontChange) {
        this.f9403a = fragmentFontChange;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentFontChange.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
