package com.sec.chaton.network;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class HttpNetworkQueue {

    /* renamed from: a */
    private static ThreadPoolExecutor f2452a = null;

    /* renamed from: b */
    private static BlockingQueue f2453b = null;

    static {
        m2746b();
    }

    /* renamed from: a */
    public static BlockingQueue m2745a() {
        return f2453b;
    }

    /* renamed from: b */
    public static void m2746b() {
        if (f2453b == null) {
            f2453b = new LinkedBlockingQueue(100);
        }
        if (f2452a == null) {
            f2452a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f2453b);
        }
        f2452a.prestartAllCoreThreads();
    }
}
