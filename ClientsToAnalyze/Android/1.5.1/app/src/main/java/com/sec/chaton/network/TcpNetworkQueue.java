package com.sec.chaton.network;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TcpNetworkQueue {

    /* renamed from: a */
    private static ThreadPoolExecutor f2499a = null;

    /* renamed from: b */
    private static BlockingQueue f2500b = null;

    static {
        m2818b();
    }

    /* renamed from: a */
    public static BlockingQueue m2817a() {
        return f2500b;
    }

    /* renamed from: b */
    public static void m2818b() {
        if (f2500b == null) {
            f2500b = new LinkedBlockingQueue(100);
        }
        if (f2499a == null) {
            f2499a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f2500b);
        }
        f2499a.prestartAllCoreThreads();
    }
}
