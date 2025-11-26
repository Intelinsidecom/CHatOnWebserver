package com.sec.chaton.chat.background;

import com.sec.chaton.util.C4904y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ChatBackgroundQueue.java */
/* renamed from: com.sec.chaton.chat.background.c */
/* loaded from: classes.dex */
public class C1584c {

    /* renamed from: a */
    private static ThreadPoolExecutor f6024a = null;

    /* renamed from: b */
    private static BlockingQueue<Runnable> f6025b = null;

    /* renamed from: a */
    public BlockingQueue<Runnable> m8440a() {
        return f6025b;
    }

    /* renamed from: b */
    public void m8441b() {
        if (f6025b == null) {
            f6025b = new LinkedBlockingQueue(100);
        }
        if (f6024a == null) {
            f6024a = new ThreadPoolExecutor(1, 1, 11L, TimeUnit.SECONDS, f6025b);
        }
        f6024a.prestartAllCoreThreads();
    }

    /* renamed from: c */
    public void m8442c() {
        f6024a.shutdown();
        if (C4904y.f17873c) {
            C4904y.m18641c("queue is empty : " + String.valueOf(f6025b.isEmpty()), "ChatBackgroundQueue");
        }
        f6025b.clear();
        f6025b = null;
        f6024a = null;
    }
}
