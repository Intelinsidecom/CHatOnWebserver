package com.sec.chaton.util;

/* loaded from: classes.dex */
public class MessageIDGenerator {
    /* renamed from: a */
    public static long m3598a() {
        long jNanoTime;
        synchronized (MessageIDGenerator.class) {
            jNanoTime = System.nanoTime();
        }
        return jNanoTime;
    }
}
