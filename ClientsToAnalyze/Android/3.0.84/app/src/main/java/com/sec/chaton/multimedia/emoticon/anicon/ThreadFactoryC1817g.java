package com.sec.chaton.multimedia.emoticon.anicon;

import java.util.concurrent.ThreadFactory;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.g */
/* loaded from: classes.dex */
class ThreadFactoryC1817g implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f6789a;

    ThreadFactoryC1817g(AniconContainer aniconContainer) {
        this.f6789a = aniconContainer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, AniconContainer.f6754b);
        thread.setPriority(1);
        return thread;
    }
}
