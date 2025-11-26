package com.sec.chaton.p037j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TcpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.ai */
/* loaded from: classes.dex */
public class C1550ai {

    /* renamed from: a */
    private static ThreadPoolExecutor f5702a = null;

    /* renamed from: b */
    private static BlockingQueue<Runnable> f5703b = null;

    static {
        m6586b();
    }

    /* renamed from: a */
    public static BlockingQueue<Runnable> m6585a() {
        return f5703b;
    }

    /* renamed from: b */
    public static void m6586b() {
        if (f5703b == null) {
            f5703b = new LinkedBlockingQueue(100);
        }
        if (f5702a == null) {
            f5702a = new ThreadPoolExecutor(1, 1, 21000L, TimeUnit.MILLISECONDS, f5703b);
        }
        f5702a.prestartAllCoreThreads();
    }
}
