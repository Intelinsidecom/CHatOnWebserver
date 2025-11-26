package com.sec.chaton.p018c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.c.s */
/* loaded from: classes.dex */
public class C0512s {

    /* renamed from: a */
    private static ThreadPoolExecutor f1670a = null;

    /* renamed from: b */
    private static BlockingQueue f1671b = null;

    static {
        m2578b();
    }

    /* renamed from: a */
    public static BlockingQueue m2577a() {
        return f1671b;
    }

    /* renamed from: b */
    public static void m2578b() {
        if (f1671b == null) {
            f1671b = new LinkedBlockingQueue(100);
        }
        if (f1670a == null) {
            f1670a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f1671b);
        }
        f1670a.prestartAllCoreThreads();
    }
}
