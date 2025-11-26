package com.sec.chaton.trunk.p050c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TrunkNetworkQueue.java */
/* renamed from: com.sec.chaton.trunk.c.g */
/* loaded from: classes.dex */
public class C1575g {

    /* renamed from: a */
    private static ThreadPoolExecutor f5674a = null;

    /* renamed from: b */
    private static BlockingQueue f5675b = null;

    static {
        m5448b();
    }

    /* renamed from: a */
    public static BlockingQueue m5447a() {
        return f5675b;
    }

    /* renamed from: b */
    public static void m5448b() {
        if (f5675b == null) {
            f5675b = new LinkedBlockingQueue(100);
        }
        if (f5674a == null) {
            f5674a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f5675b);
        }
        f5674a.prestartAllCoreThreads();
    }
}
