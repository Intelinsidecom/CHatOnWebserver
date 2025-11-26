package com.sec.chaton.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.b */
/* loaded from: classes.dex */
class ThreadFactoryC0919b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f3467a;

    ThreadFactoryC0919b(AniconContainer aniconContainer) {
        this.f3467a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f3383f);
        thread.setPriority(5);
        return thread;
    }
}
