package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.g */
/* loaded from: classes.dex */
class ThreadFactoryC3919g implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f14112a;

    ThreadFactoryC3919g(AniconContainer aniconContainer) {
        this.f14112a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f14070b);
        thread.setPriority(5);
        return thread;
    }
}
