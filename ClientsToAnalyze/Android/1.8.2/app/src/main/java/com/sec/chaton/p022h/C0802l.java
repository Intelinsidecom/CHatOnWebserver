package com.sec.chaton.p022h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.h.l */
/* loaded from: classes.dex */
public class C0802l {

    /* renamed from: a */
    private static ThreadPoolExecutor f2957a = null;

    /* renamed from: b */
    private static BlockingQueue f2958b = null;

    static {
        m3413b();
    }

    /* renamed from: a */
    public static BlockingQueue m3412a() {
        return f2958b;
    }

    /* renamed from: b */
    public static void m3413b() {
        if (f2958b == null) {
            f2958b = new LinkedBlockingQueue(100);
        }
        if (f2957a == null) {
            f2957a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f2958b);
        }
        f2957a.prestartAllCoreThreads();
    }
}
