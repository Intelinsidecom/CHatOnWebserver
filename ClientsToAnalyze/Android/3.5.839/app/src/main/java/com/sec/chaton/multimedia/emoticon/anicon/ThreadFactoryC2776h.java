package com.sec.chaton.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.h */
/* loaded from: classes.dex */
class ThreadFactoryC2776h implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f10064a;

    ThreadFactoryC2776h(AniconContainer aniconContainer) {
        this.f10064a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f10019b);
        thread.setPriority(5);
        return thread;
    }
}
