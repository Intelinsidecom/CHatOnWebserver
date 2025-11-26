package com.sec.chaton.p018c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TcpNetworkQueue.java */
/* renamed from: com.sec.chaton.c.a */
/* loaded from: classes.dex */
public class C0463a {

    /* renamed from: a */
    private static ThreadPoolExecutor f1456a = null;

    /* renamed from: b */
    private static BlockingQueue f1457b = null;

    static {
        m2380b();
    }

    /* renamed from: a */
    public static BlockingQueue m2379a() {
        return f1457b;
    }

    /* renamed from: b */
    public static void m2380b() {
        if (f1457b == null) {
            f1457b = new LinkedBlockingQueue(100);
        }
        if (f1456a == null) {
            f1456a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f1457b);
        }
        f1456a.prestartAllCoreThreads();
    }
}
