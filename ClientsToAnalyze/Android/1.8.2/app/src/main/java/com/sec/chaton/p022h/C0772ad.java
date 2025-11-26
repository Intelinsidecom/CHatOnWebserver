package com.sec.chaton.p022h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TcpNetworkQueue.java */
/* renamed from: com.sec.chaton.h.ad */
/* loaded from: classes.dex */
public class C0772ad {

    /* renamed from: a */
    private static ThreadPoolExecutor f2819a = null;

    /* renamed from: b */
    private static BlockingQueue f2820b = null;

    static {
        m3301b();
    }

    /* renamed from: a */
    public static BlockingQueue m3300a() {
        return f2820b;
    }

    /* renamed from: b */
    public static void m3301b() {
        if (f2820b == null) {
            f2820b = new LinkedBlockingQueue(100);
        }
        if (f2819a == null) {
            f2819a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f2820b);
        }
        f2819a.prestartAllCoreThreads();
    }
}
