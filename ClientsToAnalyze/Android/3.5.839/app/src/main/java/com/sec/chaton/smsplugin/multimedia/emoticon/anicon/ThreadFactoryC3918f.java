package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.f */
/* loaded from: classes.dex */
class ThreadFactoryC3918f implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f14111a;

    ThreadFactoryC3918f(AniconContainer aniconContainer) {
        this.f14111a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f14070b);
        thread.setPriority(1);
        return thread;
    }
}
