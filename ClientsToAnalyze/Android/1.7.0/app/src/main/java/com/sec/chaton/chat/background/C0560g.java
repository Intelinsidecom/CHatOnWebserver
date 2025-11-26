package com.sec.chaton.chat.background;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ChatBackgroundQueue.java */
/* renamed from: com.sec.chaton.chat.background.g */
/* loaded from: classes.dex */
public class C0560g {

    /* renamed from: a */
    private static ThreadPoolExecutor f1962a = null;

    /* renamed from: b */
    private static BlockingQueue f1963b = null;

    /* renamed from: a */
    public BlockingQueue m2766a() {
        return f1963b;
    }

    /* renamed from: b */
    public void m2767b() {
        if (f1963b == null) {
            f1963b = new LinkedBlockingQueue(100);
        }
        if (f1962a == null) {
            f1962a = new ThreadPoolExecutor(1, 1, 11L, TimeUnit.SECONDS, f1963b);
        }
        f1962a.prestartAllCoreThreads();
    }

    /* renamed from: c */
    public void m2768c() {
        f1962a.shutdown();
    }
}
