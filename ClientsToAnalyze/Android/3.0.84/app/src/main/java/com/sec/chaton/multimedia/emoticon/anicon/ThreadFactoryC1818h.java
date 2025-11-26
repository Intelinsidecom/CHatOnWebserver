package com.sec.chaton.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.h */
/* loaded from: classes.dex */
class ThreadFactoryC1818h implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f6790a;

    ThreadFactoryC1818h(AniconContainer aniconContainer) {
        this.f6790a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f6754b);
        thread.setPriority(5);
        return thread;
    }
}
