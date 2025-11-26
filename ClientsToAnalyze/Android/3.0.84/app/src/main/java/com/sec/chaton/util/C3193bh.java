package com.sec.chaton.util;

/* compiled from: MessageIDGenerator.java */
/* renamed from: com.sec.chaton.util.bh */
/* loaded from: classes.dex */
public class C3193bh {
    /* renamed from: a */
    public static long m11148a() {
        long jNanoTime;
        synchronized (C3193bh.class) {
            jNanoTime = System.nanoTime();
        }
        return jNanoTime;
    }
}
