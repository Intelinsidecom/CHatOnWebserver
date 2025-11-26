package com.sec.chaton.trunk.p042b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TrunkNetworkQueue.java */
/* renamed from: com.sec.chaton.trunk.b.c */
/* loaded from: classes.dex */
public class C1132c {

    /* renamed from: a */
    private static ThreadPoolExecutor f3957a = null;

    /* renamed from: b */
    private static BlockingQueue f3958b = null;

    static {
        m4163b();
    }

    /* renamed from: a */
    public static BlockingQueue m4162a() {
        return f3958b;
    }

    /* renamed from: b */
    public static void m4163b() {
        if (f3958b == null) {
            f3958b = new LinkedBlockingQueue(100);
        }
        if (f3957a == null) {
            f3957a = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, f3958b);
        }
        f3957a.prestartAllCoreThreads();
    }
}
