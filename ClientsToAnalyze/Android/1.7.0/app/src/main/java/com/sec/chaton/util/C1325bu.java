package com.sec.chaton.util;

/* compiled from: MessageIDGenerator.java */
/* renamed from: com.sec.chaton.util.bu */
/* loaded from: classes.dex */
public class C1325bu {
    /* renamed from: a */
    public static long m4591a() {
        long jNanoTime;
        synchronized (C1325bu.class) {
            jNanoTime = System.nanoTime();
        }
        return jNanoTime;
    }
}
