package com.sec.chaton.chat.background;

import com.sec.chaton.util.C3250y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ChatBackgroundQueue.java */
/* renamed from: com.sec.chaton.chat.background.c */
/* loaded from: classes.dex */
public class C0969c {

    /* renamed from: a */
    private static ThreadPoolExecutor f3971a = null;

    /* renamed from: b */
    private static BlockingQueue<Runnable> f3972b = null;

    /* renamed from: a */
    public BlockingQueue<Runnable> m5189a() {
        return f3972b;
    }

    /* renamed from: b */
    public void m5190b() {
        if (f3972b == null) {
            f3972b = new LinkedBlockingQueue(100);
        }
        if (f3971a == null) {
            f3971a = new ThreadPoolExecutor(1, 1, 11L, TimeUnit.SECONDS, f3972b);
        }
        f3971a.prestartAllCoreThreads();
    }

    /* renamed from: c */
    public void m5191c() {
        f3971a.shutdown();
        if (C3250y.f11735c) {
            C3250y.m11453c("queue is empty : " + String.valueOf(f3972b.isEmpty()), "ChatBackgroundQueue");
        }
        f3972b.clear();
        f3972b = null;
        f3971a = null;
    }
}
