package com.sec.chaton.util;

/* compiled from: MessageIDGenerator.java */
/* renamed from: com.sec.chaton.util.bh */
/* loaded from: classes.dex */
public class C4843bh {
    /* renamed from: a */
    public static long m18322a() {
        long jNanoTime;
        synchronized (C4843bh.class) {
            jNanoTime = System.nanoTime();
        }
        return jNanoTime;
    }
}
