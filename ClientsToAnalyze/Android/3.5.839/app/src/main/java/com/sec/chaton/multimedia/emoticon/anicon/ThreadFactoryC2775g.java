package com.sec.chaton.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.g */
/* loaded from: classes.dex */
class ThreadFactoryC2775g implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f10063a;

    ThreadFactoryC2775g(AniconContainer aniconContainer) {
        this.f10063a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f10019b);
        thread.setPriority(1);
        return thread;
    }
}
