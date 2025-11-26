package com.sec.chaton.trunk.network;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TrunkNetworkQueue {
    private static ThreadPoolExecutor excutor = null;
    private static BlockingQueue queue = null;

    static {
        threadingStart();
    }

    public static BlockingQueue getQueue() {
        return queue;
    }

    public static void threadingEnd() {
        excutor.shutdown();
    }

    public static void threadingStart() {
        if (queue == null) {
            queue = new LinkedBlockingQueue(100);
        }
        if (excutor == null) {
            excutor = new ThreadPoolExecutor(1, 1, 11000L, TimeUnit.MILLISECONDS, queue);
        }
        excutor.prestartAllCoreThreads();
    }
}
